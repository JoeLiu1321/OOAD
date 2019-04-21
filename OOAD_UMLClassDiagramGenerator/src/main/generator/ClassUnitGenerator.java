package main.generator;
import java.util.List;
import main.shapes.ClassFormat;
import main.shapes.ConcreteFormat;
import main.shapes.InterfaceFormat;

public class ClassUnitGenerator {
	private int x,y,width,height;
	public ClassUnitGenerator(){
		x=50;
		y=50;
		width=200;
		height=200;
	}
	public ClassFormat generateConcreteClassFormat(String className, List<String> methods,List<String>variables) {
		ClassFormat classFormat=new ConcreteFormat(className,x,y,width,height);
		classFormat.setMethods(methods);
		classFormat.setVariables(variables);

		x+=300;
		return classFormat;
	}

	public ClassFormat generateInterfaceClassFormat(String className, List<String> methods,List<String>variables) {
		ClassFormat classFormat=new InterfaceFormat(className,x,y,width,height);
		classFormat.setMethods(methods);
		classFormat.setVariables(variables);
		x+=300;
		return classFormat;
	}


}
