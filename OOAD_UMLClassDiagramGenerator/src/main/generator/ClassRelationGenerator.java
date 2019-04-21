package main.generator;

import main.diagrams.RelationType;
import main.shapes.ClassFormat;
import main.shapes.Relation;

public class ClassRelationGenerator {

	public ClassRelationGenerator() {
		
	}
	
	public Relation generateRelation(ClassFormat startClass , ClassFormat endClass , RelationType relationType) {
		Relation relation=new Relation(startClass,endClass,relationType);
		return relation;
	}
	
}
