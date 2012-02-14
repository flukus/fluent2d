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

		fill(false);
		penSize(30);

		add(Circle.class);
		add(Line.class).from(20f, 20f).to(80f, 80f);
		add(Line.class).from(20f, 80f).to(80f, 20f);
	}

}
