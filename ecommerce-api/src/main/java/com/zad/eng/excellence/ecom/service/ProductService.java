package com.zad.eng.excellence.ecom.service;

import java.util.List;

import com.zad.eng.excellence.ecom.model.ProductCategoryResponse;
import com.zad.eng.excellence.ecom.model.ProductResponse;

public interface ProductService {
	
	public List<ProductResponse> getAllProductDetails();
	
	public ProductResponse getProductDetails(String prodId);
	
	public List<ProductResponse> getAllProductByProductCategory(String categoryId);
	
	public List<ProductCategoryResponse> getProductCategories();
	
	public List<ProductResponse> searchProductByName(String name);

}
