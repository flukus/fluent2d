package org.fluent2d.shapes;

import java.awt.Graphics2D;
import java.awt.Image;

import org.fluent2d.Drawable;
import org.fluent2d.State;
import org.fluent2d.Theme;
import org.fluent2d.resolutions.Resolution;

public class Square extends Drawable<Square> {

	int x, y, width, height;

	public Square(Theme theme, Resolution resolution, State state) {

		super(theme, resolution, state);
	}

	@Override public void render(Image i) {
		Graphics2D g = getGraphics(i, true);
		if (options.fill)
			g.fillRect(x, y, width, height);
		else
			g.drawRect(x, y, width, height);

	}

	public Square foo() {
		return this;
	}

}
