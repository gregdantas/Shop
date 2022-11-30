package com.project.Shop.entity.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Shop.entity.Product;
import com.project.Shop.entity.User;
import com.project.Shop.repository.ProductsRepository;
import com.project.Shop.service.ProductService;

@RestController
@RequestMapping(value = "/Product")
public class UserResources {

	@Autowired
	ProductsRepository repository;
	@Autowired
	ProductService service ; 
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<Product>> list(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findALL()) ; 
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findByid(@PathVariable Long id){
		Product prodId = service.findByid(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(prodId); 
	}
}