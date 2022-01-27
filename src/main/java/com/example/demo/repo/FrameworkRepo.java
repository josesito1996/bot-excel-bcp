package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.pruebasUnitarias.PruebaUnitariaTable;

public interface FrameworkRepo extends JpaRepository<PruebaUnitariaTable, Integer> {

}
