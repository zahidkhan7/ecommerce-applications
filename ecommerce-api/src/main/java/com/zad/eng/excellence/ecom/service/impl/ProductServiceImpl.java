package com.zad.eng.excellence.ecom.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zad.eng.excellence.ecom.dao.ProductCategoryRepository;
import com.zad.eng.excellence.ecom.dao.ProductRepository;
import com.zad.eng.excellence.ecom.entity.Product;
import com.zad.eng.excellence.ecom.entity.ProductCategory;
import com.zad.eng.excellence.ecom.model.ProductCategoryResponse;
import com.zad.eng.excellence.ecom.model.ProductResponse;
import com.zad.eng.excellence.ecom.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	ProductCategoryRepository prodCategoryRepository;

	@Override
	public List<ProductResponse> getAllProductDetails() {

		List<Product> productList = productRepository.findAll();
		return productList.stream().map(this::buildProductResponse).collect(Collectors.toList());
	}

	@Override
	public ProductResponse getProductDetails(String prodId) {
		Optional<Product> product = productRepository.findById(Long.parseLong(prodId));
		return product.isPresent() ? buildProductResponse(product.get()) : new ProductResponse();
	}

	@Override
	public List<ProductResponse> getAllProductByProductCategory(String categoryId) {

		Set<Product> products = new HashSet<Product>();
		Optional<ProductCategory> productCategory = prodCategoryRepository.findById(Long.parseLong(categoryId));
		if (productCategory.isPresent()) {
			products = productCategory.get().getProducts();
		}
		List<ProductResponse> productResponse = products.stream().map(this::buildProductResponse)
				.collect(Collectors.toList());
		return productResponse;
	}
	
	@Override
	public List<ProductResponse> searchProductByName(String name) {
		List<Product> productList = productRepository.findByNameContaining(name);
		return  productList.stream().map(this::buildProductResponse).collect(Collectors.toList());		
	}


	private ProductResponse buildProductResponse(Product product) {
		ProductResponse response = new ProductResponse();
		response.setId(product.getId().intValue());
		response.setSku(product.getSku());
		response.setName(product.getName());
		response.setDescription(product.getDescription());
		response.setUnitPrice(product.getUnitPrice());
		response.setImageUrl(product.getImageUrl());
		response.setActive(Boolean.TRUE);
		response.setUnitsInStock(product.getUnitsInStock());
		response.setDateCreated(product.getDateCreated());
		response.setLastUpdated(product.getLastUpdated());
		return response;
	}

	public List<ProductCategoryResponse> getProductCategories() {
		List<ProductCategory> productCategories = prodCategoryRepository.findAll();
		return productCategories.stream().map(this::buildproductCategoryResponse).collect(Collectors.toList());
	}

	private ProductCategoryResponse buildproductCategoryResponse(ProductCategory productCategory) {
		ProductCategoryResponse response = new ProductCategoryResponse();
		response.setCategoryId(productCategory.getId().intValue());
		response.setCategoryName(productCategory.getCategoryName());
		return response;
	}


}
