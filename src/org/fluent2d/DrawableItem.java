package org.fluent2d;

public class DrawableItem {

	private final String name;
	private final Class<Drawable<?>> drawableClass;

	public DrawableItem(String name, Class<Drawable<?>> klass) {
		this.name = name;
		this.drawableClass = klass;
	}

	public String name() {
		return name;
	}

	public Class<Drawable<?>> drawableClass() {
		return drawableClass;
	}
}
