/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fac30ff.hello.todo.service;

import com.github.fac30ff.hello.todo.entity.ToDo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Family
 */
@Transactional
public class ToDoService {
    @PersistenceContext
    EntityManager em;
    
    public ToDo createToDo(ToDo todo) {
        em.persist(todo);
        return todo;
    }
    public ToDo updateToDo(ToDo todo) {
        em.merge(todo);
        return todo;
    }
    public ToDo findToDoById(Long id) {
        return em.find(ToDo.class, id);
    }
    public List<ToDo> getAllToDo() {
        return em.createQuery("select t from ToDo t", ToDo.class).getResultList();
    }
}
