package com.example.SampleSpringbootApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView form(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg", "Hello, please type...");
		return  mav;
	}
	
	@RequestMapping(value="/result", method = RequestMethod.POST)
	public ModelAndView send(ModelAndView mav, @RequestParam String text) {
		mav.setViewName("index2");
		
		//テンプレート側で大文字にする
		mav.addObject("result", text);		
		
		//追加　Javaで大文字にする処理
		String upText = text.toUpperCase();
		mav.addObject("result2", upText);

		return mav;
	}
	
}
