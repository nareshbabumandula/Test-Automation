package com.io;

import java.io.FileOutputStream;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		
		try {
			FileOutputStream fout = new FileOutputStream("./Files/OutputFile.txt");
			fout.write(65);
			fout.write(66);
			fout.write(97);
			String sText = "Hello world";
			byte b[] = sText.getBytes(); // Converting the string into a byte array
			fout.write(b);
			fout.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
