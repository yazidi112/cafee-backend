package net.yazidi.cafee.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.yazidi.cafee.entity.Product;
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
		Product product = productRepository.findById(id).get();
		return product;
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public void deleteProductById(long id) {
		productRepository.deleteById(id);
	}

	public Product updateProduct(Long id, Product product) {
		
		Product oldProduct = productRepository.findById(id).get();
		oldProduct.setName(product.getName());
		oldProduct.setPrice(product.getPrice());
		return productRepository.save(oldProduct);
	}
	
	

}
