package org.fluent2d.test;

import static org.junit.Assert.assertEquals;

import org.fluent2d.MathUtil;
import org.junit.Before;
import org.junit.Test;

public class MathUtilTest {

	@Before public void setUp() throws Exception {
	}

	@Test public void getPointBasic() {
		// basic get point test, should get 50% of 100
		// arrange
		// act
		int offset = MathUtil.getPoint(50f, 0, 100);
		// /assert
		assertEquals(50, offset);
	}

}
