package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.codereview.CodeReviewModel;

public interface CodeReviewRepo extends JpaRepository<CodeReviewModel, Integer> {

}
