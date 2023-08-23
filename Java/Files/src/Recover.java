import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListAllFiles extends SimpleFileVisitor<Path>{
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
        if(!file.getFileName().toString().endsWith(".efdc")){
            System.out.println(file.getFileName().toString());
        }

        return FileVisitResult.CONTINUE;
    }
}

public class Recover {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get("E:\\Tina");
        Files.walkFileTree(root, new ListAllFiles());

    }
}
