package net.yazidi.cafee.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import net.yazidi.cafee.entity.Product;
import net.yazidi.cafee.repository.ProductRepository;


@Service
public class ProductService {

	
	@Autowired
    private ProductRepository productRepository;
	
	public Page<Product> getProducts(Pageable pageable) {
		return productRepository.findAll(pageable);
		
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
