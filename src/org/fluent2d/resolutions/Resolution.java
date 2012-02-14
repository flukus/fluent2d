package org.fluent2d.resolutions;

import org.fluent2d.IRegion;

public class Resolution {
	public static final int LDPI = 100;
	public static final int MDPI = 200;
	public static final int HDPI = 300;
	public static final int XHDPI = 400;

	private final IRegion totalArea;
	private final IRegion paddedArea;
	public int dpi;
	public String name;

	public Resolution(IRegion totalArea, IRegion paddedArea, int dpi,
			String name) {
		this.totalArea = totalArea;
		this.paddedArea = paddedArea;
		this.dpi = dpi;
		this.name = name;
	}

	public IRegion totalArea() {
		return totalArea;
	}

	public IRegion paddedArea() {
		return paddedArea;
	}

	public String name() {
		return name;
	}

	public static final Resolution[] androidDefaults = new Resolution[] { new ActionBarIconLDPI() };
	// new Resolution(18, 18, LDPI, "drawable-ldpi"),
	// new Resolution(48, 48, HDPI, "drawable-hdpi"),
	// new Resolution(64, 64, XHDPI, "drawable-xhdpi"),
	// new Resolution(32, 32, MDPI, "drawable-mdpi"),
	// new Resolution(32, 32, MDPI, "drawable") };
}
