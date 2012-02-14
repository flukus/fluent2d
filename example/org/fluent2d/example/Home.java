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
		super.setup();
		theme.apply(options, state);
		fill();

		// create the body
		add(Square.class).top(50f).width(60f).centerHorizontal();
		// the roof
		add(Triangle.class).bottom(50f).applyDefault(Triangle.UP);

		// border
		add(Square.class).bottomR(-1).rightR(-1).fill(false).strokeSize(10);

	}
}
