package net.ncpk.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.ncpk.shoppingbackend.dao.CategoryDAO;
import net.ncpk.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	private static List<Category> categories=new ArrayList<>();
	
	/*Getting the list of active Category*/
	@Override
	public List<Category> list() {
		
		String selectActiveCategory="From Category WHERE active=:active";
		Query query =sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		
		
		return query.getResultList();
	}
	
	/*Getting single Category based on id*/
	@Override
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}
	
	
	
	/*Adding the category*/ 
	@Override
	
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
	
	/*Updating the Category*/
	@Override
	public boolean update(Category category) {
try {
			
			//update category to the database table
			
			sessionFactory.getCurrentSession().update(category);
			return true;
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
			
		}
			}
	@Override
	public boolean delete(Category category) {
try {
			category.setActive(false);
			//update category to the database table
			
			sessionFactory.getCurrentSession().update(category);
			return true;
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
			
		}
	}

}
