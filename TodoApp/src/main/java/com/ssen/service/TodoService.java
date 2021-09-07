package com.ssen.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.ssen.entity.Todo;

@Transactional
public class TodoService {
	
	@PersistenceContext
	private EntityManager manager;

	
	public Todo createTodo(Todo todo) {
		manager.persist(todo);
		return todo;
	}
	
	public Todo updateTodo(Todo todo) {
		manager.merge(todo);
		return todo;
	}
	
	public Todo findTodoById(Long id) {
		return manager.find(Todo.class, id);
	}
	
	public List<Todo> findTodos(){
		return manager.createQuery("Select t from Todo t", Todo.class).getResultList();
	}
}
