package com.example.demo.model.pruebasUnitarias;

import java.io.Serializable;

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
@Entity(name = "EstandarBuenaPracticaPu")
@Table(name = "pu_estandares")
@Getter
@NoArgsConstructor
@Setter
@ToString
public class EstandarBuenaPracticaPu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9046112395053717382L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String chapter;

	private String teamMember;

	private String topico;

	@Column(columnDefinition = "LONGTEXT")
	private String pregunta;

	private Double puntaje;

}
