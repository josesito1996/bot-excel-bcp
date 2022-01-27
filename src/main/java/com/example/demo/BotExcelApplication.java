package com.example.demo;

import static com.example.demo.util.Util.nameFromFileName;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.pruebasUnitarias.PruebaUnitariaTable;
import com.example.demo.service.CodeReviewService;
import com.example.demo.service.EstandarBuenaPracticaPuService;
import com.example.demo.service.PruebaUnitariaService;
import com.example.demo.service.PruebaUnitariaTableService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class BotExcelApplication implements CommandLineRunner {

	@Autowired
	CodeReviewService serviceCode;

	@Autowired
	PruebaUnitariaService servicePruebaUnitaria;

	@Autowired
	EstandarBuenaPracticaPuService estandarBuenaPracticaPuService;

	@Autowired
	PruebaUnitariaTableService pruebaUnitariaService;

	public static void main(String[] args) {
		SpringApplication.run(BotExcelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String ruta = "F:\\DatosPC\\Documents\\Matrices\\Sondeo 12-01-2022";
		File folder = new File(ruta);
		findAllFilesInFolder(folder);
	}

	public void findAllFilesInFolder(File folder) throws Exception {
		/**
		 * Primer For para leer la carpeta principal
		 */
		for (File file : folder.listFiles()) {
			if (file.isDirectory()) {
				String chapterName = file.getName();
				File directory = new File(folder.getAbsolutePath().concat("\\").concat(file.getName()));
				if (directory.exists() && directory.isDirectory()) {
					/**
					 * Segundo For para la leer las subCarpetas
					 * 
					 *
					 */
					for (File underFile : directory.listFiles()) {
						String fileName = underFile.getName();
						List<String> arrayDataFileName = nameFromFileName(fileName);
						if (arrayDataFileName.isEmpty()) {
							underFile.delete();
							continue;
						}
						String squad = arrayDataFileName.get(0);
						String teamMember = arrayDataFileName.get(1);
						String practica = arrayDataFileName.get(2);
						LocalDate fechaCorte = LocalDate.of(2022, 01, 12);
						if (practica.equals("PU")) {
							/**
							 * Dentro del Excel
							 */
							/*
							 * De Pruebas Unitarias, Frameworks
							 */
							try {
								InputStream inp = new FileInputStream(underFile);
								Workbook wb = WorkbookFactory.create(inp);
								String topico = "Frameworks";
								Sheet hoja = wb.getSheet(topico);
								int iRow = 4;
								int iColumnPregunta = 2;
								int iColumnPuntaje = 3;
								Row row = hoja.getRow(iRow);
								while (row != null) {
										Cell cellPregunta = row.getCell(iColumnPregunta);
										Cell cellPuntaje = row.getCell(iColumnPuntaje);
										String pregunta = cellPregunta.getStringCellValue();
										Double puntaje = cellPuntaje.getNumericCellValue();
										String subTopico = "Junit";
										log.info("Nuevo registro Frameworks {} ",
												(
													pruebaUnitariaService.registrar(PruebaUnitariaTable.builder()
														.squad(squad)
														.chapter(chapterName)
																.topico(topico)
																.subTopico(subTopico)
																.teamMember(teamMember).pregunta(pregunta)
																.fehcaCorte(fechaCorte)
																.fechaRegistro(LocalDateTime.now())
																.puntaje(puntaje).build())));
									iRow++;
									row = hoja.getRow(iRow);
								}
							} catch (Exception e) {
								System.out.println("TeamMember : " + teamMember);
								log.error("Error en Excel Hoja Frameworks {}",e);
							}
							try {
								InputStream inp = new FileInputStream(underFile);
								Workbook wb = WorkbookFactory.create(inp);
								String topico = "EstandaresTecnicasBuenasPracticas";
								Sheet hoja = wb.getSheet("EstandaresTecnicasBuenasPractic");
								int iRow = 4;
								int iColumnPregunta = 2;
								int iColumnPuntaje = 3;
								Row row = hoja.getRow(iRow);
								while (row != null) {
									if (iRow != 4 && iRow != 6) {
										Cell cellPregunta = row.getCell(iColumnPregunta);
										Cell cellPuntaje = row.getCell(iColumnPuntaje);
										String pregunta = cellPregunta.getStringCellValue();
										Double puntaje = cellPuntaje.getNumericCellValue();
										String subTopico = "";
										if (iRow >= 4 && iRow <= 10) {
											subTopico = "Solid";
										} else if (iRow >= 11 && iRow <= 19) {
											subTopico = "Clean Code";
										} else if (iRow >= 20 && iRow <= 21) {
											subTopico = "Unit Test Naming Convention";
										} else if (iRow >= 22 && iRow <= 24) {
											subTopico = "Patrón AAA";
										} else {
											subTopico = "Principio First";
										}
										log.info("Nuevo registro EstandaresTecnicasBuenasPractic {} ",
												pruebaUnitariaService.registrar(PruebaUnitariaTable.builder()
												.squad(squad)
												.chapter(chapterName)
														.topico(topico)
														.subTopico(subTopico)
														.teamMember(teamMember).pregunta(pregunta)
														.fehcaCorte(fechaCorte)
														.fechaRegistro(LocalDateTime.now())
														.puntaje(puntaje).build()));
									}
									iRow++;
									row = hoja.getRow(iRow);
								}
							} catch (Exception e) {
								System.out.println("TeamMember : " + teamMember);
								log.error("Error en Excel Hoja EstandaresTecnicasBuenasPractic {}",e);
							}
							
							try {
								InputStream inp = new FileInputStream(underFile);
								Workbook wb = WorkbookFactory.create(inp);
								String topico = "Conocimientos y Conceptos";
								Sheet hoja = wb.getSheet(topico);
								int iRow = 4;
								int iColumnPregunta = 2;
								int iColumnPuntaje = 3;
								Row row = hoja.getRow(iRow);
								while (row != null) {
										Cell cellPregunta = row.getCell(iColumnPregunta);
										Cell cellPuntaje = row.getCell(iColumnPuntaje);
										String pregunta = cellPregunta.getStringCellValue();
										Double puntaje = cellPuntaje.getNumericCellValue();
										String subTopico = "";
										if (iRow >= 4 && iRow <= 7) {
											subTopico = "Tasking";
										} else if (iRow >= 8 && iRow <= 13) {
											subTopico = "Criterios Aceptación";
										} else if (iRow >= 14 && iRow <= 19) {
											subTopico = "Xunit Test Pattern";
										}
										log.info("Nuevo registro Conocimientos y Concepto {} ",
												pruebaUnitariaService.registrar(PruebaUnitariaTable.builder()
												.squad(squad)
												.chapter(chapterName)
														.topico(topico)
														.subTopico(subTopico)
														.teamMember(teamMember).pregunta(pregunta)
														.fehcaCorte(fechaCorte)
														.fechaRegistro(LocalDateTime.now())
														.puntaje(puntaje).build()));
									iRow++;
									row = hoja.getRow(iRow);
								}
							} catch (Exception e) {
								System.out.println("TeamMember : " + teamMember);
								log.error("Error en Excel Hoja Conocimientos y Conceptos {}",e);
							}
							try {
								InputStream inp = new FileInputStream(underFile);
								Workbook wb = WorkbookFactory.create(inp);
								String topico = "Herramientas";
								Sheet hoja = wb.getSheet(topico);
								int iRow = 4;
								int iColumnPregunta = 2;
								int iColumnPuntaje = 3;
								Row row = hoja.getRow(iRow);
								while (row != null) {
										Cell cellPregunta = row.getCell(iColumnPregunta);
										Cell cellPuntaje = row.getCell(iColumnPuntaje);
										String pregunta = cellPregunta.getStringCellValue();
										Double puntaje = cellPuntaje.getNumericCellValue();
										String subTopico = "";
										if (iRow >= 4 && iRow <= 8) {
											subTopico = "Sonar";
										} else if (iRow >= 9 && iRow <= 11) {
											subTopico = "Jacoco o Sonar lint";
										}
										log.info("Nuevo registro Herramientas {} ",
												pruebaUnitariaService.registrar(PruebaUnitariaTable.builder()
												.squad(squad)
												.chapter(chapterName)
														.topico(topico)
														.subTopico(subTopico)
														.teamMember(teamMember).pregunta(pregunta)
														.fehcaCorte(fechaCorte)
														.fechaRegistro(LocalDateTime.now())
														.puntaje(puntaje).build()));
									iRow++;
									row = hoja.getRow(iRow);
								}
							} catch (Exception e) {
								System.out.println("TeamMember : " + teamMember);
								log.error("Error en Excel Hoja Herramientas {}",e);
							}
						}
					}
				}
				// log.info("El chapter : "+ file.getName() + " Cantidad CR : " + contadorCR + "
				// Contador PU : " + contadorPU);
			}
		}
	}

}
