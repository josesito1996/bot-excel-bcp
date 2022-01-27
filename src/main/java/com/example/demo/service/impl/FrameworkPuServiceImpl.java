package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.pruebasUnitarias.PruebaUnitariaTable;
import com.example.demo.repo.FrameworkRepo;
import com.example.demo.service.PruebaUnitariaTableService;

@Service
public class FrameworkPuServiceImpl implements PruebaUnitariaTableService {

	@Autowired
	private FrameworkRepo repo;
	
	@Override
	public PruebaUnitariaTable registrar(PruebaUnitariaTable t) {
		
		return repo.save(t);
	}

	@Override
	public List<PruebaUnitariaTable> listarTodos() {
		
		return repo.findAll();
	}

}
