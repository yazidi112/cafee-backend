package net.yazidi.cafee.controllers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.yazidi.cafee.models.Product;
import net.yazidi.cafee.services.ProductService;

@CrossOrigin("*")
@RestController
public class productController {
	
	 
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> index() {
		List<Product> products = productService.getProducts();
		return products;
	}
	
	@GetMapping("/product/{id}")
	public Product find(@PathVariable String id) {
		Product product = productService.getProductById(Long.parseLong(id));
		return product;
	}
	
	@DeleteMapping("/product/{id}")
	public Product delete(@PathVariable String id) {
		Product product = productService.getProductById(Long.parseLong(id));
		return product;
	}
}
