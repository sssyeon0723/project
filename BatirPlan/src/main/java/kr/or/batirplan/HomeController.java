package kr.or.batirplan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@GetMapping("/test")
	public String test() {
		log.info("hometest");
		return "test";
	}
}
