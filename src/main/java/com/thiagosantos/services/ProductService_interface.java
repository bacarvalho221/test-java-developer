package com.thiagosantos.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.thiagosantos.domain.Product;

import java.util.Optional;

public interface ProductService_interface {

    Optional<Product> findById(Long id);

    Page<Product> findAllProductsPageable(Pageable pageable);

}
