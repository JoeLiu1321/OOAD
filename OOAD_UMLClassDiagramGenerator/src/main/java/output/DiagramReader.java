package output;

import model.diagrams.UMLClassDiagram;

import java.awt.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DiagramReader {
    private ConvertStrategy strategy;

    public DiagramReader(ConvertStrategy strategy) throws Exception {
        this.strategy = strategy;
    }

    public List<String> readDiagram(String path) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String line = "";
        List<String> lineData = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null)
                lineData.add(line);
        } finally {
            br.close();
        }

        return lineData;
    }

    public UMLClassDiagram read(String path) throws Exception {
        List<String> listContent = readDiagram(path);
        String[] arrayContent = listContent.toArray(new String[listContent.size()]);
        UMLClassDiagram diagram = strategy.convert(arrayContent);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int width = (int) d.getWidth(), height = (int) d.getHeight();
        diagram.setHeight(height);
        diagram.setWidth(width);
        return diagram;
    }

}
