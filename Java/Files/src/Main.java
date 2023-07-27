import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Main {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("diretorio/subpasta");
        if (Files.notExists(path)){
            Path createDirectory = Files.createDirectories(path);
        }

        Path filePath = Paths.get(path.toString(), "notepad.txt");

        if(Files.notExists(filePath)){
            Path createFile = Files.createFile(filePath);
        }

        Path newDirectoryPath = Paths.get("novo diretorio/pasta 1/subpasta");
        if (Files.notExists(newDirectoryPath)){
            Path createNewDirectory = Files.createDirectories(newDirectoryPath);
        }
        Path newFilePath = Paths.get(newDirectoryPath.toString(), "new notepad.txt");
        if (Files.notExists(newFilePath)){
            Path createNewFile = Files.createFile(newFilePath);
        }

        File file = new File(newFilePath.toString());

        LocalDateTime date = LocalDateTime.now().minusYears(20);
        boolean isModified = file.setLastModified(date.toInstant(ZoneOffset.UTC).toEpochMilli());
        System.out.println(isModified);
    }
}