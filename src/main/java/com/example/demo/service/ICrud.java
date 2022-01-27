package com.example.demo.service;

import java.util.List;

public interface ICrud<T,ID> {

	public T registrar(T t);
	
	
	public List<T> listarTodos();
	
}
