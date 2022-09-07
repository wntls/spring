package net.koreate.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import net.koreate.vo.SampleVO;

@Controller
public class SampleController {
	
	@GetMapping("/testJSON")
	public String toJSON(Model model) {
		model.addAttribute("Hello PJS");
		return "JSON";
	}
	
	@GetMapping("getSample")
	@ResponseBody
	public SampleVO getSample(SampleVO sample) {
		System.out.println("getSample : "+ sample);
		// sample : name = 박주신, age = 27
		// '{name:"박주신",age:30}'
		return sample;
	}
	
	@GetMapping(value = "getSampleList", produces = "application/json")
	@ResponseBody
	public List<SampleVO> getSampleList(){
		List<SampleVO> sampleList = new ArrayList<>();
		for(int i=0; i<10; i++) {
			SampleVO vo = new SampleVO();
			vo.setName("PJS"+i);
			vo.setAge(i);
			sampleList.add(vo);
		}
		return sampleList;
	}
	
	@PostMapping("getSample")
	@ResponseBody
	public List<SampleVO> listSample(SampleVO vo){
		List<SampleVO> list = new ArrayList<>();
		list.add(vo);
		for(int i=1; i<10; i++) {
			SampleVO add = new SampleVO();
			add.setName(vo.getName()+i);
			add.setAge(vo.getAge()+i);
			list.add(add);
		}
		return list;
	}

	@PutMapping("testPUT")
	@ResponseBody
	// request : '{name:"박주신",age:30}'
	public SampleVO testPUT(@RequestBody SampleVO vo) {
		System.out.println("testPUT : "+vo);
		return vo;
	}
}












