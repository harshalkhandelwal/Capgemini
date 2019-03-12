package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductsCartDTO;
import com.example.demo.service.ProductsCartService;

@RestController
public class ProductsCartActionsControllerHelper {
	
	@Autowired(required=true)
	 ProductsCartService serviceRef;
	
	@RequestMapping(method=RequestMethod.GET,value="product")
	public List<ProductsCartDTO> viewProducts()
	{
		return serviceRef.viewProducts();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="product")
	public ProductsCartDTO createProduct(@RequestBody ProductsCartDTO productscartdto)
	{
		return serviceRef.createProduct(productscartdto);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/product/{id}")
	public ProductsCartDTO findProduct(@PathVariable(name="id") String id)
	{
		return serviceRef.findProduct(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/product/{id}")
	public ProductsCartDTO updateProduct(@PathVariable(name="id") String id, @RequestBody ProductsCartDTO productscartdto)
	{
		return serviceRef.updateProduct(id, productscartdto);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/product/{id}")
	public ProductsCartDTO deleteProduct(@PathVariable(name="id") String id)
	{
		return serviceRef.deleteProduct(id);
	}

}
