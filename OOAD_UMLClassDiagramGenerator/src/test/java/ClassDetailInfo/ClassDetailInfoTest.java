package ClassDetailInfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ClassDetailInfoTest {
	private ClassDetailInfo classDetailInfo;
	private ClassMemberAbstract memberVariable;
	private ClassMemberAbstract memberFunction;
	private ClassMemberAbstract relation;

	@Before
	public void setUp() throws Exception {
		memberVariable = new MemberVariable("Public", "int", "GP");
		memberFunction = new MemberFunction("Public", "int", "draw(int x, int y)");
		relation = new ClassRelationship("Extension", "Draw");
		classDetailInfo = new ClassDetailInfo();
		classDetailInfo.setClassName("UML Generator");
		classDetailInfo.setMemberVariable(memberVariable);
		classDetailInfo.setMemberFunction(memberFunction);
		classDetailInfo.setClassRelarionship(relation);
	}

	@Test
	public void testGetClassName() {
		assertEquals("UML Generator", classDetailInfo.getClassName());
	}

	@Test
	public void testClearClassName() {
		classDetailInfo.clearClassName();
		assertEquals("", classDetailInfo.getClassName());
	}

	@Test
	public void testGetMemberVariable() {
		assertEquals(memberVariable, classDetailInfo.getMemberVariable().get(0));
	}

	@Test
	public void testClearMemberVariable() {
		classDetailInfo.clearMemberVariable();
		assertTrue(classDetailInfo.getMemberVariable().isEmpty());
	}

	@Test
	public void testGetMemberFunction() {
		assertEquals(memberFunction, classDetailInfo.getMemberFunction().get(0));
	}

	@Test
	public void testClearMemberFunction() {
		classDetailInfo.clearMemberFunction();
		assertTrue(classDetailInfo.getMemberFunction().isEmpty());
	}

	@Test
	public void testGetClassRelarionship() {
		assertEquals(relation, classDetailInfo.getClassRelarionship().get(0));
	}

	@Test
	public void testClearClassRelarionship() {
		classDetailInfo.clearClassRelarionship();
		assertTrue(classDetailInfo.getClassRelarionship().isEmpty());
	}

}
