package org.fluent2d;

public class DrawableItem<T extends Drawable<?>> {

	private final String name;
	private final Class<T> drawableClass;

	public DrawableItem(Class<T> klass, String name) {
		this.name = name;
		this.drawableClass = klass;
	}

	public String name() {
		return name;
	}

	@SuppressWarnings("unchecked") public Class<Drawable<?>> drawableClass() {
		return (Class<Drawable<?>>) drawableClass;
	}
}
