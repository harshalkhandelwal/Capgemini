package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ProductsCartDTO;


@Repository
@Transactional
public class ProductsCartDAOImpl implements ProductsCartDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<ProductsCartDTO> viewProducts() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("select products from ProductsCartDTO products");
		
		return query.getResultList();
	}

	@Override
	public ProductsCartDTO createProduct(ProductsCartDTO productscartdto) {
		// TODO Auto-generated method stub
		entityManager.persist(productscartdto);
		return productscartdto;
	}

	@Override
	public ProductsCartDTO findProduct(String id) {
		// TODO Auto-generated method stub
		return (ProductsCartDTO)entityManager.find(ProductsCartDTO.class, id);
	}

	@Override
	public ProductsCartDTO updateProduct(String id, ProductsCartDTO productscartdto) {
		// TODO Auto-generated method stub
		entityManager.merge(productscartdto);
		return productscartdto;
	}

	@Override
	public ProductsCartDTO deleteProduct(String id) {
		// TODO Auto-generated method stub
		ProductsCartDTO del = (ProductsCartDTO)entityManager.find(ProductsCartDTO.class, id);
		entityManager.remove(del);
		return del;
	}

}
