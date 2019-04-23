/**
 * 
 */
package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ClassDetailInfo.ClassMemberAbstract;
import ClassDetailInfo.ClassRelarionship;

/**
 * @author GP
 *
 */
class ClassRelarionshipTest {

	/**
	 * @throws Exception
	 */
	private ClassMemberAbstract relation;
	@BeforeEach
	void setUp() throws Exception {
		relation = new ClassRelarionship();
		relation.setReference("Extension");
		relation.setName("GP");
		
		
	}

	/**
	 * Test method for {@link ClassRelarionship#reSet()}.
	 */
	@Test
	void testReSet() {
		relation.reSet();
		assertEquals("", relation.getReference());
		assertEquals("", relation.getName());
		
	}

	/**
	 * Test method for {@link ClassRelarionship#getReference()}.
	 */
	@Test
	void testGetReference() {
		assertEquals("Extension", relation.getReference());
	}

	/**
	 * Test method for {@link ClassRelarionship#getName()}.
	 */
	@Test
	void testGetName() {
		assertEquals("GP", relation.getName());
	}

}
