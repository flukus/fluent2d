package org.fluent2d.shapes;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.GeneralPath;

import org.fluent2d.DrawableRegion;
import org.fluent2d.State;
import org.fluent2d.Theme;
import org.fluent2d.resolutions.Resolution;

public class Triangle extends DrawableRegion<Triangle> {

	public static final int UP = 1;
	public static final int DOWN = 1;
	public static final int LEFT = 1;
	public static final int RIGHT = 1;
	// private int type = Triangle.CUSTOM;
	float x1, y1, x2, y2, x3, y3;

	public Triangle(Theme theme, Resolution resolution, State state) {
		super(theme, resolution, state);
		type(UP);
	}

	@Override public void render(Image i) {
		GeneralPath path = new GeneralPath(GeneralPath.WIND_NON_ZERO);
		path.moveTo(x1, y1);
		path.lineTo(x2, y2);
		path.lineTo(x3, y3);
		path.closePath();
		Graphics2D g = getGraphics(i, true);
		if (options.fill)
			g.fill(path);
		else
			g.draw(path);
	}

	public Triangle type(int type) {
		switch (type) {
		case UP:
			point1(0f, 50f);
			point1(100f, 0f);
			point1(100f, 100f);
			break;
		}
		return this;
	}

	public Triangle point1(float top, float left) {
		return this;
	}

	public Triangle point2(float top, float left) {
		return this;
	}

	public Triangle point3(float top, float left) {
		return this;
	}

}
