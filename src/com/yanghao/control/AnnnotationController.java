package com.yanghao.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnnnotationController {
	@RequestMapping("index.do")
	public String login(){
		return "index";
	}
	@RequestMapping("index2.do")
	public String indexSuccess(){
		return "index2";
	}
	@RequestMapping("error.do")
	public String error(){
		return "error";
	}
}
