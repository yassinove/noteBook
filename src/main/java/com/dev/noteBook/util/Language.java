package com.dev.noteBook.util;

public enum Language {
	PYTHON("python");

	private String name;
	Language(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Language getLanguageName(String language) {
		for (Language interpreter : Language.values()) {
			if (interpreter.name.equalsIgnoreCase(language)) {
				return interpreter;
			}
		}

		return null; // add default ?
	}
}
