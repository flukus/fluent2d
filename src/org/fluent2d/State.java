package org.fluent2d;

import java.awt.Color;
import java.util.HashMap;

public class State {

	public String name;
	Color color;
	public HashMap<String, String> attributes;

	public State(String name, Color color) {
		this.name = name;
		this.color = color;
		this.attributes = new HashMap<>();
	}

	public State addAttribute(String key, String value) {
		attributes.put(key, value);
		return this;
	}

	public String name() {
		return name;
	}

	public final static State[] buttonStates = new State[] {
			new State("normal", new Color(255, 255, 255, 76)),
			new State("pressed", Color.green).addAttribute("state_pressed",
					"true"),
			new State("focused", Color.orange).addAttribute("state_focused",
					"true"), };
}
