package com.lambazon.controller;


import com.lambazon.model.Product;
import com.lambazon.repository.ProductRepository;
import com.lambazon.service.ProductService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/products/add")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "edit"; 
    }
    
    @PostMapping("products")
	public String saveProduct() {
		return "redirect:/products";
	}

	@GetMapping("/products")
	public String getAllProducts(Model model) {
		model.addAttribute("products", productService.getAll());
		return "products";
	}

	@GetMapping("/products/edit/{id}")
	public String editProduct(Model model, @PathVariable(value = "id") String id) {
		model.addAttribute("product", productService.getById(id));
		return "edit";
	}

	@GetMapping("/products/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") String id) {
		return "redirect:/products";
	}
}
