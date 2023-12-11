package org.example;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);

        Serializer xmlSerializer = new XmlSerializer();
        xmlSerializer.serialize(book1, "xmlser.xml");


        Book test = new Book();
        test =  xmlSerializer.deserialize("xmlser.xml", Book.class);
        System.out.println("Xml:");
        System.out.println(test.getAuthor());


        Book test1 = new Book();

        Serializer txtSerializer = new TxtSerializer();
        txtSerializer.serialize(book1, "txtser.txt");

        test1 = txtSerializer.deserialize("txtser.txt", Book.class);
        System.out.println("Txt:");
        System.out.println(test1.getTitle());

        Book test2 = new Book();

        Serializer jsonSerializer = new JsonSerializer();
        jsonSerializer.serialize(book1, "jsonser.json");

        test2 = jsonSerializer.deserialize("jsonser.json", Book.class);
        System.out.println("Json:");
        System.out.println(test2.getYear());



    }
}