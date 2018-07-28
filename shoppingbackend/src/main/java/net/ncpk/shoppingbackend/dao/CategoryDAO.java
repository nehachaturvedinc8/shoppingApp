package net.ncpk.shoppingbackend.dao;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import net.ncpk.shoppingbackend.dto.Category;



public interface CategoryDAO {
	
	boolean add(Category category);
	List<Category> list();
	Category get(int id);

}
