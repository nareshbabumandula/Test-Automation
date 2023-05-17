package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



public class BufferedReaderTest {

	public void fileReaderExample() {

		boolean bFlag=false;

		try {
			System.out.println("Project Path is : " + System.getenv("$USER_HOME$"));
			File file = new File( "./Files/Data.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br= new BufferedReader(fr);
			/*
			 * int content; while ((content=br.read())!=-1) {
			 * System.out.println((char)content); }
			 */
			String line="";
			System.out.println("Reading line by line..!");
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			fr.close();
			bFlag=true;
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			if (bFlag) {
				System.out.println("Successfully read the file content");
			} else {
				System.out.println("Failed to read the file content");
			}
		}

		System.out.println("After try catch finally block..!");
		
	}

	public static void main(String[] args) {
		BufferedReaderTest fr = new BufferedReaderTest();
		fr.fileReaderExample();

	}

}
