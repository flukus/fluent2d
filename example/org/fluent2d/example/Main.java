package org.fluent2d.example;

import java.io.File;

import org.fluent2d.DrawableItem;
import org.fluent2d.FluentRunner;
import org.fluent2d.State;
import org.fluent2d.resolutions.Resolution;
import org.fluent2d.themes.ICSDarkTheme;

public class Main {

	public static void main(String[] args) {
		File rootDir = new File("bin\\res\\");
		rootDir.mkdir();
		DrawableItem<?>[] drawables = new DrawableItem<?>[] {
				new DrawableItem<Home>(Home.class, "home"),
				new DrawableItem<Close>(Close.class, "close") };

		FluentRunner.Run(rootDir, new ICSDarkTheme(), drawables,
				Resolution.androidDefaults, State.androidActionBarDefaults);
	}
}
