package com.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriterTest {

	public static void main(String[] args) throws IOException {

		FileWriter fw = new FileWriter("./files/OutputFile.txt");
		fw.write("Hello world..!");
		fw.close();

		//How to write content into a file without deleting the existing content
		try (Writer writer = Files.newBufferedWriter(
				Paths.get("./Files/OutputFile.txt"), StandardCharsets.UTF_8,
				StandardOpenOption.WRITE,
				StandardOpenOption.APPEND)) {
			writer.write("something");
		}
	}

}
