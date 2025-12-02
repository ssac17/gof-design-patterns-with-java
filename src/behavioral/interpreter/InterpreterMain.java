package behavioral.interpreter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class InterpreterMain {
    public static void main(String[] args) {
        String filePath = "/Users/sky/gof-design-patterns-with-java/src/behavioral/interpreter/program.txt";
        try {
            for (String text : Files.readAllLines(Path.of(filePath))) {
                System.out.println("text = \"" + text + "\"");
                Node node = new ProgramNode();
                node.parse(new Context(text));
                System.out.println("node = " + node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
