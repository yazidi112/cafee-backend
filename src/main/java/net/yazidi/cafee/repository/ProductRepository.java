package net.yazidi.cafee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.yazidi.cafee.entity.Product;



public interface ProductRepository extends JpaRepository<Product,Long>{

}
