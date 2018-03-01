package com.example.demo;

import io.github.cemasma.captchag.CaptchaGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.awt.*;
import java.io.IOException;

@SpringBootApplication
@Controller
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private CaptchaGenerator captchaGenerator;

	public DemoApplication() {
		captchaGenerator = new CaptchaGenerator(5);
	}

	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String hello(Model model, HttpServletRequest request) throws IOException {
		captchaGenerator = new CaptchaGenerator(5);

		captchaGenerator.setBackgroundColor(Color.BLUE);
		captchaGenerator.setTextColor(Color.RED);
		captchaGenerator.drawRandomCharacters();
		captchaGenerator.save();

		return "test";
	}

	@RequestMapping(path = "/test", method = RequestMethod.POST)
	public String hello(@RequestParam(name = "captchaCode", required = true) String captchaCode) {

		if(!captchaGenerator.check(captchaCode)) {
			// return error
			return "error";
		}
		return "redirect:test";
	}

	@GetMapping(value = "/image")
	public @ResponseBody byte[] getImage(HttpServletRequest request) throws IOException {
		return captchaGenerator.getImage();
	}
}
