package org.fluent2d.shapes;

import org.fluent2d.Drawable;
import org.fluent2d.MathUtil;
import org.fluent2d.State;
import org.fluent2d.Theme;
import org.fluent2d.resolutions.Resolution;

public class Line extends Drawable<Line> {

	int fromX, fromY, toX, toY;

	public Line(Theme theme, Resolution resolution, State state) {
		super(theme, resolution, state);

		fromX = resolution.paddedArea().left();
		fromY = resolution.paddedArea().top();
		toX = resolution.paddedArea().right();
		toY = resolution.paddedArea().bottom();
	}

	public Line from(float xP, float yP) {
		fromX = MathUtil.getPoint(xP, left(), right());
		fromY = MathUtil.getPoint(yP, top(), bottom());
		return this;

	}

	public Line to(float xP, float yP) {
		fromX = MathUtil.getPoint(xP, left(), right());
		fromY = MathUtil.getPoint(yP, top(), bottom());
		return this;
	}

}