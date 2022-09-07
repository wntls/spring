package net.koreate.security;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@GetMapping("login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("logout")
	public String logout() {
		return "user/logout";
	}
	
	@GetMapping("errorForbiden")
	public void errorForbiden() {
	}
	
	@GetMapping("logOff")
	public String logOff() {
		return "user/logOff";
	}
}
