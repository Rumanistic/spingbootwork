package com.study.springboot.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/*
 * 	기능을 수행하는 경우 			-> @Controller
 *  의존성 주입에 사용되는 경우 	-> @Component
 */
@Controller
public class MyController {
	@Autowired
	Person Person1;
	
	@Autowired
	@Qualifier("printerB")
	Printer printer;
	
	@Autowired
	Person Person2;
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "Annotation DI 사용하기";
	}
	
}
