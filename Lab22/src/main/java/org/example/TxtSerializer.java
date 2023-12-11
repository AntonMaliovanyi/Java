package org.example;

import java.io.*;


public class TxtSerializer implements Serializer{

    @Override
    public <T> void serialize(T entity, String filename) throws IOException {
        FileOutputStream file = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(entity);
        out.close();
        file.close();
    }

    @Override
    public <T> T deserialize(String filename, Class<T> entityType) throws IOException {
        FileInputStream file = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(file);

        try {
            return (T)in.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
