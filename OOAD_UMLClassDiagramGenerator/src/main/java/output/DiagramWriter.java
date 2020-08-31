package output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DiagramWriter {
    private OutputStrategy strategy;

    public DiagramWriter(OutputStrategy strategy) {
        this.strategy = strategy;
    }

    public void write(String path) throws IOException {
        String output = strategy.output();
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File(path));
            fw.write(output);
        } catch (IOException exception) {
            System.out.println("Invalid path");
        } finally {
            fw.close();
        }
    }

}
