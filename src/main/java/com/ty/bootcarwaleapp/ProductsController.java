package com.ty.bootcarwaleapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

	@Autowired
	ProductsRepository productsRepository;

	@PostMapping("/products")
	public Products saveProducts(@RequestBody Products products) {
		return productsRepository.save(products);
	}

	@GetMapping("/products")
	public List<Products> getAll() {
		return productsRepository.findAll();
	}

	@GetMapping("/products/{id}")
	public Products getProductById(@PathVariable int id) {
		Optional<Products> optional = productsRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}
	}

	@PutMapping("/products/{id}")
	public Products updateProduct(@RequestBody Products products, @PathVariable int id) {
		Optional<Products> optional = productsRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return productsRepository.save(products);
		}
	}

	@DeleteMapping("/products/{id}")
	public Products deleProduct(@PathVariable int id) {
		Optional<Products> optional = productsRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			Products products = optional.get();
			productsRepository.delete(products);
			return products;
		}
	}

}
