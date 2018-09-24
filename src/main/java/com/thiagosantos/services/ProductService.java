package com.thiagosantos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thiagosantos.domain.Product;
import com.thiagosantos.repositories.ProductRepository;
import com.thiagosantos.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService implements ProductService_interface {
	
	//SEARCH

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public Page<Product> findAllProductsPageable(Pageable pageable) {
		return productRepository.findAll(pageable);
		
	}
	
	//REST CRUD
	
	@Autowired
	private ProductRepository repo;
	
	public Product find(Long id) {
		Product prod = repo.findOne(id);
		if (prod == null) {
			throw new ObjectNotFoundException("Object not Found! ID " + id);
		}
		return prod;
		
	}
	
	public List<Product> findAll(){
		return repo.findAll();
	}
	
	public Product insert(Product obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Product update(Product obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Long id) {
		find(id);
		repo.delete(id);
	}

}
