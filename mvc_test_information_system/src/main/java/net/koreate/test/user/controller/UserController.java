package net.koreate.test.user.controller;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.koreate.test.user.service.UserService;
import net.koreate.test.user.vo.UserVO;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	@Autowired
	UserService us;
	
	
	@GetMapping("login")
	public void login() throws Exception{}
	
	@GetMapping("join")
	public void join() throws Exception{}
	
	
	/**
	 * @see Request Login 
	 * @method POST
	 * @url /user/login
	 * @param userid userpw
	 * @return redirect:/ 
	 */
	
	
	
	/**
	 * @see Request Join
	 * @method POST
	 * @url /user/join
	 * @param userid / userpw / username / email
	 * @return redirect:/user/login
	 */
	
	@PostMapping("join")
	public String join(UserVO vo) throws Exception{
		us.join(vo);
		return "redirect:/user/login";
	}
	
	
	@PostMapping("login")
	public String login(UserVO vo, Model model) throws Exception{
		model.addAttribute("userInfo",us.login(vo));
		return "redirect:/";
	}
	

}
