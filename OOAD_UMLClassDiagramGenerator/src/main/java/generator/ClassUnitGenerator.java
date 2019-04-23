package generator;
import java.util.ArrayList;
import java.util.List;

import ClassDetailInfo.*;
import adapter.ClassDetailInfoDTO;
import shapes.ClassFormat;
import shapes.ConcreteFormat;
import shapes.InterfaceFormat;

public class ClassUnitGenerator {
	private int x,y,width,height;
	public ClassUnitGenerator(){
		x=50;
		y=50;
		width=200;
		height=200;
	}

	public ClassFormat generateConcreteClassFormat(ClassDetailInfoDTO dto) {
		ClassFormat classFormat=new ConcreteFormat(dto.getClassName(),x,y,width,height);
		classFormat.setMethods(dto.getMethods());
		classFormat.setVariables(dto.getVariables());
		return classFormat;
	}

	public ClassFormat generateConcreteClassFormat(String className, List<String> methods,List<String>variables) {
		ClassFormat classFormat=new ConcreteFormat(className,x,y,width,height);
		classFormat.setMethods(methods);
		classFormat.setVariables(variables);
		return classFormat;
	}

	public ClassFormat generateInterfaceClassFormat(String className, List<String> methods,List<String>variables) {
		ClassFormat classFormat=new InterfaceFormat(className,x,y,width,height);
		classFormat.setMethods(methods);
		classFormat.setVariables(variables);
		return classFormat;
	}


}
