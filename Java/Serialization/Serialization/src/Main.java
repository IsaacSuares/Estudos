import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Gato thor = new Gato("thor", "laranja", 2, 4, 4.5, 7845849);
        System.out.println(thor);


        try {
            FileOutputStream out = new FileOutputStream("gatinho.ser");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(thor);
        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            FileInputStream in = new FileInputStream("gatinho.ser");
            ObjectInputStream ois = new ObjectInputStream(in);
            Gato copiaThor = (Gato)ois.readObject();
            System.out.println(copiaThor.toString());
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}