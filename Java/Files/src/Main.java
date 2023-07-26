import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("diretorio/subpasta");
        if (Files.notExists(path)){
            Path createDirectoty = Files.createDirectories(path);
        }

        Path filePath = Paths.get(path.toString(), "notepad.txt");

        if(Files.notExists(filePath)){
            Path createFile = Files.createFile(filePath);
        }
    }
}