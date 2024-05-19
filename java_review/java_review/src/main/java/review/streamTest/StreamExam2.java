import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamExam2 {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("src/");
        Stream<Path> stream = Files.list(path);
        stream.forEach(p -> System.out.println(p.getFileName()));
    }
}
