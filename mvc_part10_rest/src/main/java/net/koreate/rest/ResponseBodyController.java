package net.koreate.rest;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import net.koreate.vo.SampleVO;

@RestController
public class ResponseBodyController {
	
	@PostMapping(value = "xmlTest", consumes = "application/x-www-form-urlencoded")
	public ResponseEntity<String> xmlTest(SampleVO vo) throws Exception{
		// HttpEntity
		// Http 프로토콜을 이용하는 통신의 header 와 body 관련 정보를
		// 저장하는 객체
		System.out.println(vo);
		// <member>
		//		<name>박주신</name>
		//		<age>27</age>
		//</member>
		String xml = "<sample>";
		xml += "<name>"+vo.getName()+"</name>";
		xml += "<age>"+vo.getAge()+"</age>";
		xml += "</sample>";
		
		HttpHeaders header = new HttpHeaders();
		MediaType type = new MediaType("text","xml",Charset.forName("utf-8"));
		System.out.println(type);
		System.out.println(MediaType.TEXT_XML);
		System.out.println(MediaType.APPLICATION_JSON_VALUE);
		header.setContentType(type);
		ResponseEntity<String> entity = new ResponseEntity<>(xml,header,HttpStatus.OK);
		return entity;
	}
	
	@PostMapping(value = "xmlTest", consumes = "application/json")
	public String xmlTestJSON(@RequestBody SampleVO vo) throws Exception{
		ObjectMapper mapper = new XmlMapper();
		String xml = mapper.writeValueAsString(vo);
		System.out.println(vo);
		System.out.println(xml);
		SampleVO reborn = mapper.readValue(xml, SampleVO.class);
		System.out.println("reborn : "+reborn);
		mapper = new JsonMapper();
		return xml;
	}
	
}












