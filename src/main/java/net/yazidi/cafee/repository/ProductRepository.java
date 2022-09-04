package net.yazidi.cafee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.yazidi.cafee.models.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

}
