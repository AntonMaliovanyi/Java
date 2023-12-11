// XmlSerializer.java
package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlSerializer implements Serializer {

    private final XmlMapper xmlMapper = new XmlMapper();

    @Override
    public <T> void serialize(T entity, String filename) throws IOException {
        String xml = xmlMapper.writeValueAsString(entity);
        Files.write(Paths.get(filename), xml.getBytes());
    }

    @Override
    public <T> T deserialize(String filename, Class<T> entityType) throws IOException {
        return xmlMapper.readValue(Paths.get(filename).toFile(), entityType);
    }
}
