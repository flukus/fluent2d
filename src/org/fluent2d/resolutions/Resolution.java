package org.fluent2d.resolutions;

import org.fluent2d.Region;

public class Resolution {
	// public static final int LDPI = 100;
	// public static final int MDPI = 200;
	// public static final int HDPI = 300;
	// public static final int XHDPI = 400;

	// public int width;
	// public int height;
	private final Region totalArea;
	private final Region paddedArea;
	// public int dpi;
	// public int margin = 5;
	public String folderName;

	public Resolution(Region totalArea, Region paddedArea, String folderName) {
		this.totalArea = totalArea;
		this.paddedArea = paddedArea;
	}

	public Region totalArea() {
		return totalArea;
	}

	public Region paddedArea() {
		return paddedArea;
	}

	// public Resolution(int width, int height, int dpi, String folderName) {
	// this.width = width;
	// this.height = height;
	// this.dpi = dpi;
	// this.folderName = folderName;
	// }

	public static final Resolution[] androidDefaults = new Resolution[] { new ActionBarIconLDPI() };
	// new Resolution(18, 18, LDPI, "drawable-ldpi"),
	// new Resolution(48, 48, HDPI, "drawable-hdpi"),
	// new Resolution(64, 64, XHDPI, "drawable-xhdpi"),
	// new Resolution(32, 32, MDPI, "drawable-mdpi"),
	// new Resolution(32, 32, MDPI, "drawable") };
}
