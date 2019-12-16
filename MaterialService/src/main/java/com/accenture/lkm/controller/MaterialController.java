package com.accenture.lkm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.service.MaterialService;

@RestController
public class MaterialController {

	@Autowired
	MaterialService mService;

	@GetMapping("/")
	public String index() {
		return "Welcome to Spring Boot Material Service API!";
	}

	@GetMapping(value = "/material/controller/getMaterialCategories", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaterialCategoryBean>> getMaterialCategories() {

		List<MaterialCategoryBean> categoryBeans = mService.getMaterialCategories();
		return new ResponseEntity<List<MaterialCategoryBean>>(categoryBeans, HttpStatus.OK);
	}

	@GetMapping(value = "/material/controller/getMaterialCategoryById/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MaterialCategoryBean> getMaterialCategoryById(@PathVariable String categoryId) {

		MaterialCategoryBean categoryBean = mService.getMaterialCategoryById(categoryId);
		return new ResponseEntity<MaterialCategoryBean>(categoryBean, HttpStatus.OK);
	}

}
