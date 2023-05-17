package com.io;

import java.io.FileInputStream;

public class FileInputStreamTest {

	public static void main(String[] args) {
		
		try {
			long startTime = System.currentTimeMillis();
			FileInputStream fis = new FileInputStream("./Files/InputFile.txt");
				int i = 0;
			while((i=fis.read())!=-1) {
				System.out.print((char)i);
			}
	
			fis.close();
			long endTime = System.currentTimeMillis();
			System.out.println("Time taken by FileInputStream class is : "+ (endTime-startTime) + " ms");
			} catch (Exception e) {
			System.out.println(e);
		}

	}

}
