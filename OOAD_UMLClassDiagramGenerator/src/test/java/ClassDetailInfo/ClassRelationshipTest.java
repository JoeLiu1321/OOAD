/**
 * 
 */
package ClassDetailInfo;

import static org.junit.Assert.assertEquals;
import model.ClassDetailInfo.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author GP
 *
 */
public class ClassRelationshipTest {

	/**
	 * @throws Exception
	 */
	private ClassMemberAbstract relation;

	@Before
	public void setUp() throws Exception {
		relation = new ClassRelationship();
		relation.setReference("Extension");
		relation.setName("GP");

	}

	/**
	 * Test method for {@link ClassRelationship#reSet()}.
	 */
	@Test
	public void testReSet() {
		relation.reSet();
		assertEquals("", relation.getReference());
		assertEquals("", relation.getName());

	}

	/**
	 * Test method for {@link ClassRelationship#getReference()}.
	 */
	@Test
	public void testGetReference() {
		assertEquals("Extension", relation.getReference());
	}

	/**
	 * Test method for {@link ClassRelationship#getName()}.
	 */
	@Test
	public void testGetName() {
		assertEquals("GP", relation.getName());
	}

}
