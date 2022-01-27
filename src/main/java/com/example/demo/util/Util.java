package com.example.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Util {

	public static List<String> nameFromFileName(String fileName) {
		try {
			if (fileName != null && !fileName.isEmpty() && (!fileName.contains(".ini"))) {
				String fileMock = fileName.substring(0, fileName.indexOf("."));
				String[] arrayName = fileMock.split("_");
				return Arrays.asList(arrayName);
			}
			return new ArrayList<>();
		} catch (Exception e) {
			log.error("Error al procesar nombre de archivo : {}", e);
			return new ArrayList<>();
		}
	}

	public static void main(String... srgs) throws Exception {
		System.out.println(nameFromFileName("SQGESTIONDETALENTO_AyrtonAldayrNevesEstrada_CR.xlsx"));
	}

}
