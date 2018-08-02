package net.ncpk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import net.ncpk.shoppingbackend.dao.ProductDAO;
import net.ncpk.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	
private static AnnotationConfigApplicationContext context;
	
	
	private static ProductDAO productDAO;
	private Product product;

	
	@BeforeClass
	public static void init() {
		context =new AnnotationConfigApplicationContext();
		context.scan("net.ncpk.shoppingbackend");
		context.refresh();
		
		productDAO=(ProductDAO) context.getBean("productDAO");
	}
	
	
	
	@Test
	public void testCRUDCategory() {
		
		//Add Operation 
		category =new Category();
		category.setName("Television");
		category.setDescription("some description Television");
		category.setImageURL("CAT_1.png");
		assertEquals("Successfully added category",true,categoryDAO.add(category));
		
		category=new Category();
		category.setName("Mobile");
		category.setDescription("some description Mobile");
		category.setImageURL("CAT_2.png");
		assertEquals("Successfully added category",true,categoryDAO.add(category));
		
		category=new Category();
		category.setName("Laptop");
		category.setDescription("some description Laptop");
		category.setImageURL("CAT_3.png");
		assertEquals("Successfully added category",true,categoryDAO.add(category));
		
		
		//Fetching and renaming the category
		category= categoryDAO.get(1);
		category.setName("TV");
		assertEquals("Successfully fetched and updated a single category",true,categoryDAO.update(category));
		
		//Delete the category
		
		category= categoryDAO.get(2);
		category.setActive(false);
		assertEquals("Successfully deleted a single category",true,categoryDAO.delete(category));
		
		//Fetching the list of Categories
		
		assertEquals("Successfully fetched the list of active categories",2,categoryDAO.list().size());
		
	}

}
