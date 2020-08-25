package ClassDetailInfo;

import model.ClassDetailInfo.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MemberFunctionTest {

	private ClassMemberAbstract memberFunction;

	@Before
	public void setUp() throws Exception {
		memberFunction = new MemberFunction();
		memberFunction.setReference("Public");
		memberFunction.setType("int");
		memberFunction.setName("draw(int x, int y)");

	}

	@Test
	public void testReSet() {
		memberFunction.reSet();
		assertEquals("", memberFunction.getReference());
		assertEquals("", memberFunction.getType());
		assertEquals("", memberFunction.getName());
	}

	@Test
	public void testGetReference() {
		assertEquals("Public", memberFunction.getReference());
	}

	@Test
	public void testGetType() {
		assertEquals("int", memberFunction.getType());
	}

	@Test
	public void testGetName() {
		assertEquals("draw(int x, int y)", memberFunction.getName());
	}

}
