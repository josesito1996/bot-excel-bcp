package com.example.demo.model.codereview;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

@Table(name = "cr_lineamiento_programacion")
@Entity(name = "CodeReviewModel")
@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
@ToString
public class CodeReviewModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String chapter;
	
	private String squad;

	private String teamMember;

	private String topico;
	
	private String subTopico;

	@Column(columnDefinition = "LONGTEXT")
	private String pregunta;

	private Double puntaje;
	
	private LocalDate fehcaCorte;
	
	private LocalDateTime fechaRegistro;

}
