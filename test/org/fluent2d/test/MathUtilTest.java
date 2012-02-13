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

	@Test public void getPointWithPadding() {
		// should get halfway point between 10 and 90 (50)
		// arrange
		// act
		int offset = MathUtil.getPoint(50f, 10, 90);
		// /assert
		assertEquals(50, offset);

	}

	@Test public void getPointWithIrregularPadding() {
		// should get halfway point between 20 and 90 (55)
		// arrange
		// act
		int offset = MathUtil.getPoint(50f, 20, 90);
		// /assert
		assertEquals(55, offset);
	}

	@Test public void getCenterOffsetBasic() {
		// the center point between 0 100 for an object with 0 width should be
		// 50
		// arrange
		// act
		int offset = MathUtil.getCentreOffset(0, 100, 0, 0);
		// assert
		assertEquals(50, offset);
	}

	@Test public void getCenterOffsetWithInnerWidth() {
		// the center offset between 0 100 for an object with 20 width should be
		// 40
		// arrange
		// act
		int offset = MathUtil.getCentreOffset(0, 100, 0, 20);
		// assert
		assertEquals(40, offset);
	}

	@Test public void getCenterOffsetWithInnerWidthAndPadding() {
		// the center offset between 10 90 for an object with 20 width should be
		// 40
		// arrange
		// act
		int offset = MathUtil.getCentreOffset(10, 90, 0, 20);
		// assert
		assertEquals(40, offset);
	}

	@Test public void getCenterOffsetWithInnerWidthAndIrregularPadding() {
		// the center offset between 20 90 for an object with 20 width should be
		// 35
		// arrange
		// act
		int offset = MathUtil.getCentreOffset(20, 90, 0, 20);
		// assert
		assertEquals(45, offset);
	}

}
