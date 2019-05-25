package adapter;

import shapes.ClassFormat;

public class ClassFormatOutputDTO {
    private String output;

    public ClassFormatOutputDTO(ClassFormat classFormat) {
        parseOutput(classFormat);
    }

    public void parseOutput(ClassFormat classFormat){
        StringBuilder builder=new StringBuilder();
        builder.append("ClassName:").append(classFormat.getClassName());
        builder.append(";");
        builder.append("Methods:").append(classFormat.getMethods());
        builder.append(";");
        builder.append("Variables:").append(classFormat.getVariables());
        builder.append(";");
        builder.append("StartPoint:").append(classFormat.x).append(",").append(classFormat.y);
        builder.append(";");
        builder.append("HeightWidth:").append(classFormat.height).append(",").append(classFormat.width);
        output=builder.toString();
    }

    public String getOutput(){
        return output;
    }
}
