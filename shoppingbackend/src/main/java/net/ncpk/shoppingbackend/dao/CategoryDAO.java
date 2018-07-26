package net.ncpk.shoppingbackend.dao;

import java.util.List;

import net.ncpk.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);

}
