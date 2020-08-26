package generator;

import model.classDetail.ClassFormat;
import model.classDetail.Relation;
import model.diagrams.RelationType;

public class ClassRelationGenerator {

	public ClassRelationGenerator() {

	}

	public Relation generateRelation(ClassFormat startClass, ClassFormat endClass, RelationType relationType) {
		Relation relation = new Relation(startClass, endClass, relationType);
		return relation;
	}

}
