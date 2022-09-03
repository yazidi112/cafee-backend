package net.yazidi.cafee.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import net.yazidi.cafee.models.Product;

@Component
public class ProductService {

	List<Product> products= Arrays.asList(
			new Product(1,"cd",30),
			new Product(1,"dvd",430),
			new Product(1,"pc",4),
			new Product(1,"printer",40)
		);
	
	public List<Product> getProducts() {
		
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
