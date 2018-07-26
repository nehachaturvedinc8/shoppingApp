package net.ncpk.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.ncpk.shoppingbackend.dao.CategoryDAO;
import net.ncpk.shoppingbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		
		ModelAndView mv =new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		mv.addObject("categories", categoryDAO.list());
		return mv;
		
	}
	@RequestMapping(value= {"/about"})
	public ModelAndView about() {
		
		ModelAndView mv =new ModelAndView("page");
		mv.addObject("title", "About us");
		mv.addObject("userClickAbout", true);
		return mv;
		
	}
	@RequestMapping(value= {"/contact"})
	public ModelAndView contact() {
		
		ModelAndView mv =new ModelAndView("page");
		mv.addObject("title", "Contact us");
		mv.addObject("userClickContact", true);
		return mv;
		
	}
	

	
	/*methods to load all the products all category */
	@RequestMapping(value= {"/show/all/products"})
	public ModelAndView showAllProducts() {
		
		ModelAndView mv =new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		mv.addObject("categories", categoryDAO.list());
		return mv;
		
	}
	
	/*methods to load all the products of single category */
	@RequestMapping(value= {"/show/category/{id}/products"})
	public ModelAndView showAllProducts(@PathVariable("id") int id) {
		
		ModelAndView mv =new ModelAndView("page");
		Category category =categoryDAO.get(id);
		mv.addObject("title", category.getName());
		mv.addObject("userClickCategoryProducts", true);
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		// passing single category
		mv.addObject("category", category);
		return mv;
		
	}
	
	
/*	
	@RequestMapping(value= {"/test"})
public ModelAndView test(@RequestParam(value="greeting", required=false) String greeting ) {
		
		if(greeting==null) {
			greeting="welcome";
		}
		ModelAndView mv =new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
		
	}
	
	@RequestMapping(value= {"/test/{greeting}"})
	public ModelAndView test(@PathVariable("greeting")String greeting ) {
			
			if(greeting==null) {
				greeting="welcome";
			}
			ModelAndView mv =new ModelAndView("page");
			mv.addObject("greeting", greeting);
			return mv;
			
		}*/


}
