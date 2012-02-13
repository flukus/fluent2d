package org.fluent2d.example;

import org.fluent2d.Drawable;
import org.fluent2d.State;
import org.fluent2d.Theme;
import org.fluent2d.resolutions.Resolution;
import org.fluent2d.shapes.Circle;
import org.fluent2d.shapes.Line;

public class Close extends Drawable<Close> {

	public Close(Theme theme, Resolution resolution, State state) {
		super(theme, resolution, state);
	}

	@Override public void setup() {
		super.setup();

		add(Circle.class).fill(false);
		add(Line.class).from(10f, 10f).to(90f, 90f);
		add(Line.class).from(10f, 90f).to(90f, 10f);
	}

}
