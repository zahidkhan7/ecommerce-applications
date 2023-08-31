package com.zad.eng.excellence.ecom.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zad.eng.excellence.ecom.model.ProductCategoryResponse;
import com.zad.eng.excellence.ecom.service.ProductService;


@RestController
@CrossOrigin
@RequestMapping("/productCategories")
public class ProductCategoryResourceController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<ProductCategoryResponse>> getProductCategories(){
		List<ProductCategoryResponse> productCategories = productService.getProductCategories();
		return new ResponseEntity<List<ProductCategoryResponse>>(productCategories, HttpStatus.OK);
	}

}
