package org.fluent2d.resolutions;

import org.fluent2d.Region;

public class DebugResolution extends Resolution {

	public DebugResolution() {
		super(new Region(0, 0, 1000, 1000), new Region(50, 50, 950, 950),
				1000000, "debug");
	}
}
