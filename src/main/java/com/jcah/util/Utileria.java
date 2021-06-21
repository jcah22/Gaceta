package com.jcah.util;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {

	public static String guardarArchivo(MultipartFile multipart, String ruta) {
		
		//obtenemos el nombre original del archivo 
		String nombreOriginal = multipart.getOriginalFilename();
		try {
			//formamos el nombre del archivo para guardarlo en el dd
			File imageFile = new File(ruta+nombreOriginal);
			System.out.println("Archivo: " + imageFile.getAbsolutePath());
			//guardamos fisicamente el archivo en hd
			multipart.transferTo(imageFile);
			return nombreOriginal;	
			
		}catch (Exception e) {
			System.out.println("Error"+ e.getMessage());
			return null;
		}
	}
}
