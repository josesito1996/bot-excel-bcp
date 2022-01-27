package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.codereview.CodeReviewModel;
import com.example.demo.repo.CodeReviewRepo;
import com.example.demo.service.CodeReviewService;

@Service
public class CodeReviewServiceImpl implements CodeReviewService {

	
	@Autowired
	private CodeReviewRepo repo;
	
	@Override
	public CodeReviewModel registrar(CodeReviewModel t) {
		return repo.save(t);
	}

	@Override
	public List<CodeReviewModel> listarTodos() {
		return repo.findAll();
	}

}
