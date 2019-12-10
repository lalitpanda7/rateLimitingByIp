package com.ratelimiting.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	public static int count=0; 
	@GetMapping("/rest")
    public boolean getCaseSections(HttpServletRequest request) {


		BufferedWriter bw = null;
		FileWriter fw = null;

		try {			  
		        // Creating date format 
		        DateFormat simple = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z"); 
		  
		        // Creating date from milliseconds 
		        // using Date() constructor 
		        Date result = new Date(System.currentTimeMillis()); 
			String data = " "+ ++count+ " request recived"+result.getTime();

			File file = new File("D:\\Personal\\Rate Limiting\\test.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(data);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}	
		}
		return true;
	}

}
