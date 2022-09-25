package net.yazidi.cafee.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.yazidi.cafee.entity.Product;
import net.yazidi.cafee.services.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class productController {
	
	 
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public Page<Product> index(
			@RequestParam(value = "page",defaultValue="0") int page,
			@RequestParam(value = "size", defaultValue="4")int size,
			@RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
			@RequestParam(value = "sortDir", defaultValue="asc") String sortDir) {
		
		Sort sort = sortDir.equalsIgnoreCase("asc")? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page, size,sort);
		return productService.getProducts(pageable);
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
