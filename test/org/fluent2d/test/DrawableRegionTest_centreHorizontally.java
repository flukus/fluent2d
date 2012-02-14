package org.fluent2d.test;

import static org.junit.Assert.assertEquals;

import org.fluent2d.DrawableRegion;
import org.fluent2d.Region;
import org.fluent2d.resolutions.Resolution;
import org.junit.Before;
import org.junit.Test;

public class DrawableRegionTest_centreHorizontally {

	private DrawableRegion<?> region;

	@Before public void setUp() throws Exception {
		region = new DrawableRegion<>(null, new Resolution(new Region(0, 0,
				100, 100), new Region(10, 10, 90, 90), 0, null), null);
	}

	@Test public void center0WidthItem() {
		// center an object with no width
		// arrange
		region.right(region.left());
		// act
		region.centerHorizontal();
		// assert
		assertEquals(50, region.left());
		assertEquals(50, region.right());
	}

	@Test public void center10WidthItem() {
		// center an object 1o pixels wide
		// arrange
		region.right(20);
		// act
		region.centerHorizontal();
		// assert
		assertEquals(45, region.left());
		assertEquals(55, region.right());
	}

}
