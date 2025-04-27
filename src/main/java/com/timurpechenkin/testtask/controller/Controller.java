package com.timurpechenkin.testtask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.timurpechenkin.testtask.service.XLSXService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	XLSXService xlsxService;

	@Tag(name = "getMinNumber", description = "Get N-th minimum integer number from XLSX file")
	@GetMapping("/min/{n}")
	public String getMinNumber(@RequestParam String filePath, @PathVariable int n) {
		return xlsxService.getMinNumber(filePath, n);
	}
}
