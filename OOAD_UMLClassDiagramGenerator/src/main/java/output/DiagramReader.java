package output;

import diagrams.UMLClassDiagram;


import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;

public class DiagramReader {
    private UMLClassDiagram diagram;
    public DiagramReader(String path)throws Exception{
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int width=(int)d.getWidth(),height=(int)d.getHeight();
        diagram=new UMLClassDiagram(width,height);
        readDiagram(path);
    }

    public void readDiagram(String path)throws Exception {
        BufferedReader br=new BufferedReader(new FileReader(new File(path)));
        String line="";
        List<String> lineData=new ArrayList<>();
        Map<String,Map<String,String>> allData=new HashMap<>();
        while((line=br.readLine())!=null)
            lineData.add(line);
        for(int i=0;i<lineData.size();i++){
            String[]attributes=lineData.get(i).split(";");
            Map<String,String>dataDetail=new HashMap<>();
            for(String attr:attributes){
                String[]attrPair=attr.split(":");
                dataDetail.put(attrPair[0],attrPair[1]);
            }
            allData.put(String.valueOf(i),dataDetail);
        }
        System.out.println(allData);
    }
}
