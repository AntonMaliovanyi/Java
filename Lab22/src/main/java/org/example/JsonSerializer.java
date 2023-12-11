// XmlSerializer.java
package org.example;

import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.io.File;
import java.nio.file.Paths;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerializer implements Serializer {

    private final ObjectMapper jsonMapper = new JsonMapper();

    @Override
    public <T> void serialize(T entity, String filename) throws IOException {
        jsonMapper.writeValue(new File(filename), entity);
    }

    @Override
    public <T> T deserialize(String filename, Class<T> entityType) throws IOException {
        return jsonMapper.readValue(Paths.get(filename).toFile(), entityType);
    }
}
