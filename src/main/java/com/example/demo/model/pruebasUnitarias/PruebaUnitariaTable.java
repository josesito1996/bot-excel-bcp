package com.example.demo.model.pruebasUnitarias;

import java.io.Serializable;
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

@AllArgsConstructor
@Builder
@Entity(name = "FrameworkPu")
@Table(name = "pruebas_unitarias")
@Getter
@NoArgsConstructor
@Setter
@ToString
public class PruebaUnitariaTable implements Serializable {

	private static final long serialVersionUID = -6692582042798320936L;

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
