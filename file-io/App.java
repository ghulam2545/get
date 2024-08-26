// stream of 2 category 
// 1. byte stream 
// 2. char stream

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {

        String filename = "sample.txt";

        // read whole file at once
        byte[] data;
        try {
            data = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String str = new String(data);
        System.out.println(str);

        // read char by char
        try (FileReader reader = new FileReader(filename)) {
            int ch = 0;
            while (true) {
                ch = reader.read();
                if (ch == -1)
                    break;
                else
                    System.out.print((char) ch);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // write char by char
        try (FileWriter writer = new FileWriter("code.cpp")) {
            String s = "int main() { return 0; }";
            writer.write(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}