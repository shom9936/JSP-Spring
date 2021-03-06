package com.myspring.pro29.ex01;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/*")
public class TestController {
	@RequestMapping("/hello")
	public String hello() {
		return "Hello REST!!"; // /hello로 요청 시 브라우저로 문자열을 전송한다.
	}
	
	// 브라우저에서 요청 시 {num} 부분의 값이 @PathVariable로 지정됩니다. 
	@RequestMapping(value = "/notice/{num}", method = RequestMethod.GET)
	public String notice(@PathVariable("num") int num) throws Exception {
		// 요청 URL에서 지정된 값이 num에 자동으로 할당됩니다.
		return String.valueOf(num);
	}
	
}