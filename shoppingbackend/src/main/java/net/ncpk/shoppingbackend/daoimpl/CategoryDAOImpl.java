package net.ncpk.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.ncpk.shoppingbackend.dao.CategoryDAO;
import net.ncpk.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	private static List<Category> categories=new ArrayList<>();
	static {
		
		Category category=new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("some description Television");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("some description Mobile");
		category.setImageURL("CAT_2.png");
		categories.add(category);
		
		category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("some description Laptop");
		category.setImageURL("CAT_3.png");
		categories.add(category);
	}
	@Override
	public List<Category> list() {
		
		return categories;
	}
	@Override
	public Category get(int id) {
		for (Category category:categories) {
			if(category.getId()==id) {
				return category;
			}
			
		}
		return null;
	}
	@Override
	@Transactional
	public boolean add(Category category) {
		try {
			
			//add category to the database table
			
			sessionFactory.getCurrentSession().persist(category);
			return true;
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
			
		}
	}

}
