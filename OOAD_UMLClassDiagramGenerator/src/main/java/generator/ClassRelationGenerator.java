package generator;

import model.diagrams.RelationType;
import model.shapes.ClassFormat;
import model.shapes.Relation;

public class ClassRelationGenerator {

	public ClassRelationGenerator() {

	}

	public Relation generateRelation(ClassFormat startClass, ClassFormat endClass, RelationType relationType) {
		Relation relation = new Relation(startClass, endClass, relationType);
		return relation;
	}

}
