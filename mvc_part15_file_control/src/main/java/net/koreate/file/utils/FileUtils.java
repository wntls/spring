package net.koreate.file.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;


public class FileUtils {
	
	public static String uploadFile(String realPath, MultipartFile file) throws Exception{
		String uploadFileName = "";
		
		UUID uid = UUID.randomUUID();
		String originalName = file.getOriginalFilename();
		String savedName = uid.toString().replace("-", "");
		// a7s6df567adfa5d4f5d_박주신 그날.jpg
		savedName +="_"+(originalName.replace("_", ""));
		System.out.println(savedName);
		// \2022\08\04
		String datePath = calcPath(realPath);
		File f = new File(realPath+datePath,savedName);
		file.transferTo(f);
		
		// 업로드 된 파일의 확장자
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		System.out.println(formatName);
		if(MediaUtils.getMediaType(formatName) != null) {
			// 이미지 파일
			uploadFileName = makeThumbnail(realPath,datePath,savedName);
		}else {
			// 일반 파일
			uploadFileName = makeFileName(realPath,datePath,savedName);
		}
		System.out.println("uploadFileName : "+uploadFileName);
		return uploadFileName;
	}
	// URL 경로로 변경하여 반환
	private static String makeFileName(String realPath, String datePath, String savedName) {
		String fileName = "";
		fileName = datePath+File.separator+savedName;
		fileName = fileName.replace(File.separatorChar, '/');
		return fileName;
	}
	
	// 썸네일 생성 후 URL 경로로 썸네일 이미지 경로 반환 
	private static String makeThumbnail(String realPath, String datePath, String savedName) throws IOException {
		String name = "";
		// 썸네일 이미지 생성
		File file = new File(realPath+datePath,savedName);
		// 지정 된 위치의 이미지 정보를 BufferedImage 타입으로 반환
		BufferedImage image = ImageIO.read(file);
		
		// scalr 객체를 이용해서 원본 이미지 복제
		// 복제시 크기 지정
		BufferedImage sourceImage = Scalr.resize(image,Scalr.Method.AUTOMATIC,	// 고정 크기에 따른 상태 크기
												Scalr.Mode.FIT_TO_HEIGHT,		// 높이를 고정 크기로 지정
												100);							// 높이틑 100px, 비율은 크기에 따라
		String thumbnailImage = realPath+datePath+File.separator+"s_"+savedName;
		String ext = savedName.substring(savedName.lastIndexOf(".")+1);
		ImageIO.write(sourceImage, ext, new File(thumbnailImage));
		
		name = thumbnailImage.substring(realPath.length()).replace(File.separatorChar, '/');
		System.out.println(name);
		return name;
	}

	public static String calcPath(String realPath) {
		String datePath = "";
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator
							+ new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		datePath = monthPath +File.separator
				   + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		System.out.println(datePath);
		mkDir(realPath,yearPath,monthPath,datePath);
		return datePath;
	}
	
	// 날짜 형식의 디렉토리 생성
	public static void mkDir(String realPath, String... path) {
		if(new File(realPath+path[path.length-1]).exists()) {
			return;
		}
		
		for(String p : path) {
			String mkDir = realPath+p;
			System.out.println("mkDir : "+mkDir);
			File file = new File(mkDir);
			if(!file.exists()) {
				file.mkdir();
			}
		}
	}
	
	public static boolean deleteFile(String realPath, String fileName) {
		boolean isDeleted = false;
		// 일반 파일 -> 파일 삭제
		// 이미지 파일 -> 원본,썸네일 삭제
		
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		fileName = (fileName).replace('/', File.separatorChar);
				// 일반 파일이나, 썸네일 이미지 삭제
		isDeleted = new File(realPath+(fileName)).delete();
		
		if(MediaUtils.getMediaType(formatName) != null) {
			// 이미지 파일
			fileName = fileName.replace("s_", "");
			isDeleted = new File(realPath+fileName).delete();
		}
		return isDeleted;
	}
	
	// 요청한 파일 정보를 byte[] 로 반환
	public static byte[] getBytes(String realPath, String fileName) throws Exception{
		File file = new File(realPath,fileName);
		InputStream is = new FileInputStream(file);
		/*
		long length = file.length();
		length = is.available();
		byte[] bytes = new byte[(int)length];
		
		for(int i=0; i<bytes.length; i++) {
			bytes[i] = (byte)is.read();
		}
		is.close();
		return bytes;
		*/
		return IOUtils.toByteArray(is);
	}
	
	// 다운로드 파일 header 정보
	public static HttpHeaders getOctetHeaders(String fileName) throws Exception{
		HttpHeaders header = new HttpHeaders();
		// 8비트 / 1byte 단위의 이진 데이터
		//header.add("Content-Type", "application/octet-stream");
		header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 원본 파일 이름
		fileName = fileName.substring(fileName.lastIndexOf("_")+1);
		// 부가 정보
		header.add("content-disposition", "attachment;fileName=\""+
				new String(fileName.getBytes("UTF-8"),"ISO-8859-1")+"\"");
		
		return header;
	}
	
	
	
	
}












