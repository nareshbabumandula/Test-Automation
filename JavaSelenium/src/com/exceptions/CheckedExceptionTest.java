package com.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionTest {

	void checkedExceptionExample() throws IOException {
		File file = new File("./files/Data.txt");
		FileReader fr = new FileReader(file);

		int i;

		while((i=fr.read())!=-1) {
			System.out.print((char)i);
		}
		System.out.println();
	}

	void checkedExceptionWithTryCatchExample(){
		boolean bFlag=false;
		
		System.out.println("Executing code via try catch block..!");
		try {
			File file = new File("./files/Data123.txt");
			FileReader fr = new FileReader(file);
			int i;
			while((i=fr.read())!=-1) {
				System.out.print((char)i);
			}
			bFlag=true;
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println();
			if (bFlag==true) {
				System.out.println("Successfully read the file..!");
			} else {
				System.out.println("Failed to read the file..!");
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		CheckedExceptionTest cet = new CheckedExceptionTest();
		cet.checkedExceptionExample();
		cet.checkedExceptionWithTryCatchExample();

	}

}
