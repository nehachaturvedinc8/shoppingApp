package net.ncpk.shoppingbackend.dao;

import java.util.List;

import net.ncpk.shoppingbackend.dto.Product;

public interface ProductDAO {
	
	Product get(int id);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);

	
	//Business Methods 
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
}


