package it.elijah.pizzeria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.elijah.pizzeria.model.Pizza;
import it.elijah.pizzeria.repository.PizzaRepository;

@Controller
@RequestMapping("/")
public class PizzaController {
	
	@Autowired
	private PizzaRepository repository;
	
	@GetMapping
	public String index(Model model, @RequestParam(name = "search", required = false) String search) {
		
		List<Pizza> pizze = new ArrayList<>();
		
		if(search == null || search.isBlank()) {			
			pizze = repository.findAll();
		} else {
			pizze = repository.findByNomeIgnoreCase(search);
		}
		
		model.addAttribute("pizze", pizze);
		
		return "index";
	}
	
	@GetMapping("/pizza/{id}")
	public String show(@PathVariable("id") Integer pizzaId, Model model) {
		
		model.addAttribute("pizza", repository.getReferenceById(pizzaId));
		
		return "/pizza/index";
	}
}
