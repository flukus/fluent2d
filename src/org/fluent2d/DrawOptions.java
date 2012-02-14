package org.fluent2d;

import java.awt.Color;

public class DrawOptions implements Cloneable {

	public Color color;
	public double rotate;
	public boolean fill;
	public Color fillColor;
	public float penSize;

	public DrawOptions() {

		color = Color.black;
		rotate = 0;
	}

	public static final DrawOptions defaults = new DrawOptions();

	@Override public DrawOptions clone() {
		try {
			return (DrawOptions) super.clone();
		} catch (CloneNotSupportedException e) {
			return new DrawOptions();
		}
	}
}
