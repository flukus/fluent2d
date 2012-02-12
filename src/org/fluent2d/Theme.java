package org.fluent2d;

import java.awt.Color;
import java.util.HashMap;

import org.fluent2d.themes.ICSDarkTheme;

public class Theme {

	protected HashMap<String, Color> primaryColors = new HashMap<>();
	protected Color primaryDefault;
	protected String name;
	protected String prefix;

	public Theme() {
	}

	public Color getPrimaryColorFor(State state) {
		if (primaryColors.containsKey(state.name))
			return primaryColors.get(state.name);
		else
			return primaryDefault;
	}

	public void apply(DrawOptions options, State state) {
		options.color = getPrimaryColorFor(state);
		options.fill = true;
		options.fillColor = getPrimaryColorFor(state);
	}

	public static final Theme[] defaultThemes = new Theme[] { new ICSDarkTheme() };

}
