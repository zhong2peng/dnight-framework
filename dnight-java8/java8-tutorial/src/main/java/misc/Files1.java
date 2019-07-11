package misc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class Files1 {

    public static void main(String[] args) {
//        testReaderLines();
        testWriter();
    }

    private static void testReaderLines() {
        Path path = Paths.get("/Users/zhongpeng/Desktop/git/github/dnight-framework/dnight-java8/java8-tutorial/res/nashorn1.js");
        try {
            BufferedReader reader = Files.newBufferedReader(path);
            long countPrints = reader.lines()
                    .filter(line -> line.contains("print"))
                    .count();
            System.out.println(countPrints);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testWriter() {
        Path path = Paths.get("/Users/zhongpeng/Desktop/git/github/dnight-framework/dnight-java8/java8-tutorial/res/res/output.js");
        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(path);
            bufferedWriter.write("print('Hello World');");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testReader() throws IOException {
        Path path = Paths.get("res/nashorn1.js");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println(reader.readLine());
        }
    }

    private static void testWalk() throws IOException {
        Path start = Paths.get("");
        int maxDepth = 5;
        try (Stream<Path> stream = Files.walk(start, maxDepth)) {
            String joined = stream
                    .map(String::valueOf)
                    .filter(path -> path.endsWith(".js"))
                    .collect(Collectors.joining("; "));
            System.out.println("walk(): " + joined);
        }
    }

    private static void testFind() throws IOException {
        Path start = Paths.get("");
        int maxDepth = 5;
        try (Stream<Path> stream = Files.find(start, maxDepth, (path, attr) ->
                String.valueOf(path).endsWith(".js"))) {
            String joined = stream
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining("; "));
            System.out.println("find(): " + joined);
        }
    }

    private static void testList() throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get(""))) {
            String joined = stream
                    .map(String::valueOf)
                    .filter(path -> !path.startsWith("."))
                    .sorted()
                    .collect(Collectors.joining("; "));
            System.out.println("list(): " + joined);
        }
    }

    private static void testLines() throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get("res/nashorn1.js"))) {
            stream
                    .filter(line -> line.contains("print"))
                    .map(String::trim)
                    .forEach(System.out::println);
        }
    }

    private static void testReadWriteLines() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("res/nashorn1.js"));
        lines.add("print('foobar');");
        Files.write(Paths.get("res", "nashorn1-modified.js"), lines);
    }
}
