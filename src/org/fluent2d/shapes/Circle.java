package org.fluent2d.shapes;

import java.awt.Graphics2D;
import java.awt.Image;

import org.fluent2d.DrawableRegion;
import org.fluent2d.State;
import org.fluent2d.Theme;
import org.fluent2d.resolutions.Resolution;

public class Circle extends DrawableRegion<Circle> {

	public Circle(Theme theme, Resolution resolution, State state) {
		super(theme, resolution, state);
	}

	@Override public void render(Image i) {
		Graphics2D g = super.getGraphics(i, true);

		if (options.fill)
			g.fillOval(left(), top(), right() - left(), bottom() - top());
		else
			g.drawOval(left(), top(), right() - left(), bottom() - top());
	}

}
