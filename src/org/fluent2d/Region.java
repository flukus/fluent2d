package org.fluent2d;

public class Region implements IRegion {

	private final int top;
	private final int left;
	private final int bottom;
	private final int right;

	public Region(int top, int left, int bottom, int right) {
		this.top = top;
		this.left = left;
		this.bottom = bottom;
		this.right = right;
	}

	@Override public int top() {
		return this.top;
	}

	@Override public int left() {
		return this.left;
	}

	@Override public int bottom() {
		return this.bottom;
	}

	@Override public int right() {
		return this.right;
	}

}
