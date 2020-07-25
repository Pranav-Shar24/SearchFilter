package io.pranav.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.pranav.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	/*
	 * @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%" +
	 * " OR p.brand LIKE %?1%" + " OR p.madein LIKE %?1%" +
	 * " OR CONCAT(p.price, '') LIKE %?1%") public List<Product> search(String
	 * keyword);
	 */
	 @Query("SELECT p FROM Product p WHERE CONCAT(p.name, p.brand, p.madein, p.price) LIKE %?1%")
	 public List<Product> search(String keyword);
}
