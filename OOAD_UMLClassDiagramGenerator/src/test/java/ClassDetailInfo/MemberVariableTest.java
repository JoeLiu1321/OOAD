package ClassDetailInfo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MemberVariableTest {
	private ClassMemberAbstract memberVariable;

	@Before
	public void setUp() throws Exception {
		memberVariable = new MemberVariable();
		memberVariable.setReference("Public");
		memberVariable.setType("int");
		memberVariable.setName("GP");
	}

	@Test
	public void testReSet() {
		memberVariable.reSet();
		assertEquals("", memberVariable.getReference());
		assertEquals("", memberVariable.getType());
		assertEquals("", memberVariable.getName());
	}

	@Test
	public void testGetReference() {
		assertEquals("Public", memberVariable.getReference());
	}

	@Test
	public void testGetType() {
		assertEquals("int", memberVariable.getType());
	}

	@Test
	public void testGetName() {
		assertEquals("GP", memberVariable.getName());
	}

}
