package net.ncpk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.ncpk.shoppingbackend.dao.CategoryDAO;
import net.ncpk.shoppingbackend.dto.Category;

public class CategoryTest {
	
	
	private static AnnotationConfigApplicationContext context;
	
	
	private static CategoryDAO categoryDAO;
	private Category category;

	
	@BeforeClass
	public static void init() {
		context =new AnnotationConfigApplicationContext();
		context.scan("net.ncpk.shoppingbackend");
		context.refresh();
		
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	}
	
	@Test
	public void testAddCategory() {
		category =new Category();
		category.setName("Television");
		category.setDescription("some description Television");
		category.setImageURL("CAT_1.png");
		assertEquals("Successfully added category",true,categoryDAO.add(category));
		
	}
}
