package com.ssen.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ssen.entity.Todo;
import com.ssen.service.TodoService;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoController {
	
	@Inject
	private TodoService service;
	
	@Path("new")
	@POST
	public Response createTodo(Todo todo) {
		//api/v1/todo/new
		
		service.createTodo(todo);
		return Response.ok(todo).build();
	}

	@Path("update")
	@PUT
	public Response updateTodo(Todo todo) {
		service.updateTodo(todo);
		return Response.ok(todo).build();
	}
	
	@Path("{id}")
	@GET
	public Todo findTodoById(@PathParam("id") Long id) {
		return service.findTodoById(id);
	}

	@Path("list")
	@GET
	public List<Todo> findTodos(){
		return service.findTodos();
	}
	
	@Path("status")
	@POST
	public Response markAsComplete(@QueryParam("id") Long id) {
		Todo todo = service.findTodoById(id);
		todo.setCompleted(true);
		Todo todoUpdated = service.updateTodo(todo);
		
		return Response.ok(todoUpdated).build();
	}
}
