/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fac30ff.hello.todo.rest;

import com.github.fac30ff.hello.todo.entity.ToDo;
import com.github.fac30ff.hello.todo.service.ToDoService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Family
 */
@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ToDoRest {
    @Inject
    ToDoService toDoService;
    
    @Path("new")
    @POST
    public Response createToDo(ToDo todo) {
        toDoService.createToDo(todo);
        return Response.ok(todo).build();
    }
    
    @Path("update")
    @PUT
    public Response updateToDo(ToDo toDo) {
        toDoService.updateToDo(toDo);
        return Response.ok(toDo).build();
    }
    
    @Path("{id}")
    @GET
    public ToDo getToDo(@PathParam("id")Long id) {
        return toDoService.findToDoById(id);
    }
    
    @Path("list")
    @GET
    public List<ToDo> getToDos() {
        return toDoService.getAllToDo();
    }
    
    @Path("status")
    @POST
    public Response markAsComplete(@QueryParam("id")Long id) {
        ToDo todo = toDoService.findToDoById(id);
        todo.setIsCompleted(true);
        toDoService.updateToDo(todo);
        return Response.ok(todo).build();
    }
    
}
