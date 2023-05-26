package com.restassured.interview;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test implements Serializable{
	int a=10;
	int b=20;
}

public class SerializationandDeserializationTest {

	Test t = new Test();
	
	void SerializationandDeserializationDemo() throws IOException, ClassNotFoundException {
		// Serialization
		FileOutputStream fos = new FileOutputStream("test.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(t);
		
		// Deserialization
		FileInputStream fis = new FileInputStream("test.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Test t1 = (Test)ois.readObject();
		System.out.println(t1.a);
		System.out.println(t1.b);
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SerializationandDeserializationTest sdt = new SerializationandDeserializationTest();
		sdt.SerializationandDeserializationDemo();

	}

}
