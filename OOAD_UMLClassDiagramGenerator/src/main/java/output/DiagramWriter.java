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
        File f = new File(path);

        String output = strategy.output();
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            fw.write(output);
        } catch (IOException exception) {
            System.out.println("Invalid path");
        } finally {
            fw.close();
        }
    }

}
