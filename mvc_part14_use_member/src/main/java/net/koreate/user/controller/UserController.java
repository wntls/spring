package net.koreate.user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import net.koreate.user.service.UserService;
import net.koreate.user.vo.UserVO;

@Controller
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService us;
	
	@RequestMapping("/signIn")
	public String signIn() {
		return "user/signIn";
	}
	
	@RequestMapping("/signUp")
	public String signUp() {
		return "user/signUp";
	}
	
	@PostMapping("/signUpPost")
	public String signUpPost(UserVO vo) throws Exception{
		us.signUp(vo);
		return "redirect:/user/signIn";
	}
	
	@PostMapping("/signInPost")
	public String signInPost(UserVO vo, //HttpSession session
			Model model) throws Exception{
		//session.setAttribute("userInfo", us.signIn(vo));
		model.addAttribute("userInfo",us.signIn(vo));
		return "redirect:/";
	}
	
	@GetMapping("/signOut")
	public String signOut(HttpSession session, HttpServletResponse response, //HttpServletRequest request
			@CookieValue(name = "signInCookie", required = false) Cookie signInCookie) {
		if(session.getAttribute("userInfo") != null) {
			session.removeAttribute("userInfo");
			session.removeAttribute("invalidate");
			System.out.println("logOut signInCookie : "+signInCookie);
			if(signInCookie != null) {
				signInCookie.setMaxAge(0);
				signInCookie.setPath("/");
				response.addCookie(signInCookie);
			}
		}
		return "redirect:/";
	}
}




















