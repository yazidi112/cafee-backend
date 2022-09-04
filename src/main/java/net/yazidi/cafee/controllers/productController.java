package net.yazidi.cafee.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Product find(@PathVariable Long id) {
		Product product = productService.getProductById(id);
		return product;
	}
	
	@DeleteMapping("/product/{id}")
	public String delete(@PathVariable Long id) {
		productService.deleteProductById(id);
		return "Delete successfully";
	}
	
	@PostMapping("/product")
	public Product add(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@PutMapping("/product/{id}")
	public Product update(@RequestBody Product product,@PathVariable Long id) {
		return productService.updateProduct(id,product);
	}
}
