package net.koreate.common.task;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import net.koreate.board.dao.AttachmentDAO;

@Component
@RequiredArgsConstructor
public class FileCheckTask {
	
	private final String uploadFolder;
	private final ServletContext context;
	private final AttachmentDAO dao;
	
	// cron schedule
	// 매초마다
	@Scheduled(cron="* * * * * *")
	public void testTask() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(sdf.format(new Date()));
	}
	
	//@Scheduled(cron="0 0 4 * * *") // 매일 4시 0분 0초
	@Scheduled(cron="0 * * * * *")
	public void fileCheck() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("/yyy/MM/dd/");
		long time = 1000 * 60 * 60 * 24;
		String datePath = sdf.format(new Date(System.currentTimeMillis()-time));
		datePath = datePath.replace('/', File.separatorChar);
		String realPath = context.getRealPath(File.separator+uploadFolder);
		List<String> list = dao.getTrashAttach();
		System.out.println(list);
		removeList(realPath, datePath, list);
	}
	
	// uploadFolder, /년/월/일, 테이블에 저장된 업로드 파일 리스트
	public void removeList(String realPath, String datePath, List<String> list) {
		// 삭제할 파일 목록
		List<String> removeFiles = new ArrayList<>(); 
		
		File file = new File(realPath,datePath);
		if(file.exists()) {
			List<File> files = Arrays.asList(file.listFiles());
			for(File f : files) {
				String fileName = f.getName();
				System.out.println(fileName);
				datePath = datePath.replace(File.separatorChar, '/');
				String filePath = datePath+fileName;
				String thumbnail = datePath+"s_"+fileName;
				// db에 저장 되지 않은 파일이 존재하면 삭제 리스트에 추가
				if(!list.contains(filePath) && !list.contains(thumbnail)) {
					removeFiles.add(filePath);
				}
			}// end for
			
			for(String s : removeFiles) {
				System.out.println("remove file : " + s);
				new File(realPath+(s).replace('/', File.separatorChar)).delete();
			}
		}
	}
}




























