package com.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public void fileReaderExample() {

		boolean bFlag=false;

		try {
			File file = new File("./files/Data.txt"); // Relative path
			if (file.exists()) {
				System.out.println("File exists");
				System.out.println(file.canRead());
				System.out.println(file.canWrite());
				System.out.println(file.canExecute());
				
				System.out.println(file.getName());
				System.out.println(file.getAbsolutePath());
				System.out.println(file.getPath());
				System.out.println(file.isFile());
			} else {
				System.out.println("File does not exist in the specified path");
			}
			FileReader fr = new FileReader(file);
			int content;
			while ((content=fr.read())!=-1) {
				System.out.print((char)content);
			}
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
		FileReaderTest fr = new FileReaderTest();
		fr.fileReaderExample();

	}

}
