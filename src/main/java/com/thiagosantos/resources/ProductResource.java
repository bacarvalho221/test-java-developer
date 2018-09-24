package com.thiagosantos.resources;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.thiagosantos.domain.Product;
import com.thiagosantos.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource {
	
	//Find Product Valid!
	
	@Autowired
	private ProductService service;
	
	@RequestMapping(value="/{product_id}", method=RequestMethod.GET)
	public ResponseEntity<Product> find(@PathVariable Long product_id) {
		
	Product obj = service.find(product_id);
		return ResponseEntity.ok().body(obj);
	}
	
	//CRUD ENDPOINT /products
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Product>> findAll() {
		
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Product obj) {
		
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{product_id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Product obj, @PathVariable Long id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{product_id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long product_id){
		service.delete(product_id);
		return ResponseEntity.noContent().build();
		
	}

}
