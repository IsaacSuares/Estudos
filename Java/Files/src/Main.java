import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;

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

        //LocalDateTime date = LocalDateTime.now().minusYears(20);
        //boolean isModified = file.setLastModified(date.toInstant(ZoneOffset.UTC).toEpochMilli());
        //System.out.println(isModified);

        BasicFileAttributeView a = Files.getFileAttributeView(newFilePath, BasicFileAttributeView.class);
        System.out.println(a.readAttributes().creationTime().toString());
        FileTime ft = FileTime.fromMillis(LocalDateTime.now().minusYears(5).toInstant(ZoneOffset.UTC).toEpochMilli());
        System.out.println(ft);
        a.setTimes(null, null, ft);
        System.out.println(a.readAttributes().creationTime().toString());

        Path path2 = Paths.get(".");
        try(DirectoryStream<Path> ds = Files.newDirectoryStream(path2);){
            for (Path p : ds){
                System.out.println(p.getFileName());
            }
        }catch (IOException e){
            e.printStackTrace();
        }




    }
}