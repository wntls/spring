package net.koreate.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.koreate.vo.ProductVO;

@Controller
public class SampleController {
	
	// /WEB-INF/views/doA.jsp
	@RequestMapping("doA")
	public void doA() {
		System.out.println("doA Call");
	}
	
	// /WEB-INF/views/doB.jsp
	@RequestMapping("doB")
	public void doB() {
		System.out.println("doB Call");
	}
	
	@RequestMapping("doC")
	public String doC(Model model) {
		model.addAttribute("msg","doC model data");
		return "result";
	}
	
	@RequestMapping(value = "doD", method = RequestMethod.GET)
	public String doD(@RequestParam(name = "msg", required = true)String message, Model model) {
		System.out.println("msg : "+message);
		model.addAttribute("msg",message);
		return "result";
	}
	
	@RequestMapping(value = "doD", method = RequestMethod.POST)
	public String doD(String msg, int age, Model model) {
		System.out.println(msg);
		System.out.println(age);
		model.addAttribute("msg",msg+":"+age);
		return "result";
	}
	
	@RequestMapping("product")
	public void product(Model model) {
		ProductVO productVO = new ProductVO("TV",100);
		model.addAttribute("product",productVO);
		// 첫글자 소문자로
		ProductVO vo = new ProductVO("AUDIO",50);
		model.addAttribute(vo);
	}
	
	@RequestMapping("doH")
	public ModelAndView doH() {
		ModelAndView mav = new ModelAndView();
		mav.addObject(new ProductVO("Sample1",100000));
		ProductVO product = new ProductVO("Sample2",150000);
		mav.addObject("product",product);
		mav.setViewName("product");
		return mav;
	}
	
	@RequestMapping(value = "productWrite", method = RequestMethod.POST)
	public ModelAndView productWrite(String name, int price, ModelAndView mav, ProductVO vo) {
		mav.addObject(new ProductVO(name,price));
		mav.addObject("product",vo);
		mav.setViewName("product");
		return mav;
	}
	
	@RequestMapping("redirect")
	public String redirect() {
		return "redirect:main.home";
	}
	
}























