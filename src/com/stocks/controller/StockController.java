package com.stocks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trade")
public class StockController {
	
	@GetMapping("/fetchall")
	private String getTradeData() {
		return "hello";

	}

}
