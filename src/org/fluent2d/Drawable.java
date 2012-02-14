package org.fluent2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.fluent2d.resolutions.Resolution;

@SuppressWarnings("unchecked")
public class Drawable<T extends Drawable<?>> {

	public List<Drawable<?>> drawables;
	public DrawOptions options;

	protected final Theme theme;
	protected final Resolution resolution;
	protected final State state;

	public Drawable(Theme theme, Resolution resolution, State state) {
		super();
		drawables = new ArrayList<>();
		options = new DrawOptions();

		this.theme = theme;
		this.resolution = resolution;
		this.state = state;
	}

	public String getFilename() {
		return "icon";
	}

	protected void setOptions(DrawOptions options) {
		this.options = options;
	}

	public void setup() {

		theme.apply(options, state);
		// setup children Drawable
		for (Drawable<?> d : drawables)
			d.setup();
	}

	public void render(Image i) {
		for (Drawable<?> d : drawables)
			d.render(i);
	}

	protected Graphics2D getGraphics(Image i, boolean applyAttributes) {
		Graphics2D g = (Graphics2D) i.getGraphics();
		RenderingHints rh = g.getRenderingHints();
		rh.put(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHints(rh);

		if (applyAttributes) {
			g.setColor(options.color);
			g.rotate(options.rotate);
			g.setStroke(new BasicStroke(options.penSize,
					java.awt.BasicStroke.CAP_ROUND,
					java.awt.BasicStroke.JOIN_ROUND));
		}
		return g;
	}

	public T color(String color) {
		this.options.color = Color.black;
		return (T) this;
	}

	public T color(Color color) {
		this.options.color = color;
		return (T) this;
	}

	public T color(int r, int g, int b, int alpha) {
		this.options.color = new Color(r, g, b, alpha);
		return (T) this;
	}

	public T rotate(int degrees) {
		this.options.rotate = degrees;
		return (T) this;
	}

	public T fill() {
		options.fillColor = options.color;
		options.fill = true;
		return (T) this;
	}

	public T fill(boolean value) {
		options.fill = value;
		return (T) this;
	}

	public T penSize(float penSize) {
		this.options.penSize = penSize;
		return (T) this;
	}

	public <N extends Drawable<?>> N add(Class<N> klass) {
		try {
			Constructor<N> constructor = klass.getConstructor(Theme.class,
					Resolution.class, State.class);
			N n = constructor.newInstance(this.theme, this.resolution,
					this.state);
			drawables.add(n);
			n.setOptions(options.clone());
			return n;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
