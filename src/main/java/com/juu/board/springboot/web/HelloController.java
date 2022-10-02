package com.juu.board.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juu.board.springboot.dto.HelloResponseDto;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/hello/dto")
	public HelloResponseDto helloDti(@RequestParam String name, @RequestParam int amount) {
		return new HelloResponseDto(name, amount);
	}
}
