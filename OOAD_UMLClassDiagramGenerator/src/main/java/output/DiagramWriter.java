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
        String fileExtension = strategy.getExtension();
        int extensionIndex = path.lastIndexOf(".");
        String newPath = path.substring(0, extensionIndex) + fileExtension;
        File f = new File(newPath);

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
