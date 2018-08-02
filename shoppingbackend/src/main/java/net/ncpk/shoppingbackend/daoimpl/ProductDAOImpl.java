package net.ncpk.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.ncpk.shoppingbackend.dao.ProductDAO;
import net.ncpk.shoppingbackend.dto.Product;
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	private SessionFactory sessionFactory;

	
	/*Getting single Product by ID*/
	@Override
	public Product get(int productId) {
		try {
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/*Returning the list of All Product without any filter*/
	@Override
	public List<Product> list() {
		
		return sessionFactory.getCurrentSession().createQuery(" From Product", Product.class).getResultList();
	}

	/*adding the product*/
	@Override
	public boolean add(Product product) {
		try {
			
			 sessionFactory.getCurrentSession().persist(product);
			 return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
/*Updating the product*/
	@Override
	public boolean update(Product product) {
		try {
			
			 sessionFactory.getCurrentSession().update(product);
			 return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			 return this.update(product);
			 
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String queryString="From Product Where active=:active";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setParameter("active", true);
		return query.getResultList();
		
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String queryString="From Product Where active=:active AND categoryId=:categoryId";
		Query query = sessionFactory.getCurrentSession()
				.createQuery(queryString)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId);
		return query.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String queryString="From Product  Where active=:active Order By id";
		Query query = sessionFactory.getCurrentSession()
				.createQuery(queryString)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count);
		
		return query.getResultList();
	}

}
