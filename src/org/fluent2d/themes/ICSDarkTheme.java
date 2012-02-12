package org.fluent2d.themes;

import java.awt.Color;

import org.fluent2d.Theme;

public class ICSDarkTheme extends Theme {

	public ICSDarkTheme() {
		super();
		name = "ics_dark";
		prefix = "ics_dark";
		primaryDefault = new Color(255, 255, 255, 204);
		primaryColors.put("pressed", new Color(255, 150, 150, 255));
		primaryColors.put("focused", new Color(0, 255, 0, 204));
		primaryColors.put("disabled", new Color(255, 255, 255, 102));
	}

}