package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.pruebasUnitarias.EstandarBuenaPracticaPu;
import com.example.demo.repo.EstandarBuenaPracticaPuRepo;
import com.example.demo.service.EstandarBuenaPracticaPuService;

@Service
public class EstandarBuenaPracticaPuServiceImpl implements EstandarBuenaPracticaPuService {

	@Autowired
	private EstandarBuenaPracticaPuRepo repo;
	
	@Override
	public EstandarBuenaPracticaPu registrar(EstandarBuenaPracticaPu t) {
		
		return repo.save(t);
	}

	@Override
	public List<EstandarBuenaPracticaPu> listarTodos() {
		
		return repo.findAll();
	}

}
