package com.example.SampleSpringbootApplication;

//import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	//ModelAndViewを使用する
	@RequestMapping(value = "/")
	public ModelAndView indexMav(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg", "Hello World");
		System.out.println("ModelAndViewを使用する");
		return  mav;
	}
	
	//Modelを使用する
	@RequestMapping(value = "/model")
	public String indexModel(Model model) {
		model.addAttribute("msg2", "Hello World (Model)");
	//	model.addAttribute("now", new Date().toString());	//現在時刻の表示
		return "index";
	}
	
	//URLに入力した値をModelAndViewに渡して画面に表示する
	@RequestMapping(value = "/{str}")
	public ModelAndView indexStr(ModelAndView mav, @PathVariable String str) {
		mav.setViewName("index");
		mav.addObject("msg", "Hello World");
		mav.addObject("moji", "入力された文字は「　" + str  + "　」です。");
		return  mav;
	}
	
	//URLに入力した値をModelに渡して画面に表示する
	@RequestMapping(value = "/model/{str}")
	public String indexStrModel(Model model, @PathVariable String str) {
		model.addAttribute("msg2", "Hello World (Model)");
		model.addAttribute("moji2", "入力された文字は「　" + str  + "　」です。");
		return  "index";
	}
	
}
