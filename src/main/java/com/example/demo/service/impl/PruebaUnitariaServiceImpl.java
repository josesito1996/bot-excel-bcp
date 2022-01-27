package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.codereview.PruebaUnitariaModel;
import com.example.demo.repo.PruebaUnitariaRepo;
import com.example.demo.service.PruebaUnitariaService;

@Service
public class PruebaUnitariaServiceImpl implements PruebaUnitariaService {

	
	@Autowired
	private PruebaUnitariaRepo repo;

	@Override
	public PruebaUnitariaModel registrar(PruebaUnitariaModel t) {
		return repo.save(t);
	}

	@Override
	public List<PruebaUnitariaModel> listarTodos() {
		return repo.findAll();
	}
	


}
