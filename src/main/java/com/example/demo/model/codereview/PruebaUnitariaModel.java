package com.example.demo.model.codereview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "cr_lineamiento_prueba_unitaria")
@Entity(name = "PruebaUnitariaModel")
@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
@ToString
public class PruebaUnitariaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String chapter;

	private String teamMember;

	@Column(columnDefinition = "LONGTEXT")
	private String pregunta;

	private Double puntaje;

}
