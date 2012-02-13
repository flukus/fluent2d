package org.fluent2d.example;

import org.fluent2d.Drawable;
import org.fluent2d.State;
import org.fluent2d.Theme;
import org.fluent2d.resolutions.Resolution;
import org.fluent2d.shapes.Square;
import org.fluent2d.shapes.Triangle;

public class Home extends Drawable<Home> {

	public Home(Theme theme, Resolution resolution, State state) {
		super(theme, resolution, state);
	}

	@Override public String getFilename() {
		return "home2";
	}

	@Override public void setup() {

		theme.apply(options, state);
		color(theme.getPrimaryColorFor(state));

		// create the body
		add(Square.class).top(50f).width(60f).centerHorizontal();
		// the roof
		add(Triangle.class).type(Triangle.UP).bottom(50f);

		// border
		add(Square.class).bottomR(-1).rightR(-1).fill(false);

	}
}
