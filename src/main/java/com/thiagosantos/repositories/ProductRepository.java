package com.thiagosantos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiagosantos.domain.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findById(Long id);  
	
}
