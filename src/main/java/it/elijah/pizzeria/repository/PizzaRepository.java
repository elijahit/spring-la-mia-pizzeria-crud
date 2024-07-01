package it.elijah.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.elijah.pizzeria.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

}
