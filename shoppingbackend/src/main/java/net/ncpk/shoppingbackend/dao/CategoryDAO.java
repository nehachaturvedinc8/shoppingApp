package net.ncpk.shoppingbackend.dao;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import net.ncpk.shoppingbackend.dto.Category;



public interface CategoryDAO {
	
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);

}
