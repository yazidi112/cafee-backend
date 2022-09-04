package net.yazidi.cafee.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.yazidi.cafee.models.Product;
import net.yazidi.cafee.models.User;
import net.yazidi.cafee.repository.ProductRepository;
import net.yazidi.cafee.repository.UserRepository;

@Component
public class ProductService {

	
	@Autowired
    private ProductRepository productRepository;
	
	public List<Product> getProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}
	
	public Product getProductById(long id) {
		Product product = new Product(1,"printer",40);
		return product;
	}

	public boolean deleteProductById(long id) {
		
		return false;
	}
	
	

}
