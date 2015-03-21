package vigen.baghdasaryan.sololearn.simpleparser.helper;

import java.util.LinkedHashMap;

public class SquareBracketML {

	private String tag = "";
	private LinkedHashMap<String, String> attributes = null;
	private String content = "";

	public SquareBracketML(String markup, String content) {
		tag = parseTag(markup);
		attributes = parseAttributes(markup);
		this.content = content;
	}

	private String parseTag(String markup) {
		return markup;
	}

	private LinkedHashMap<String, String> parseAttributes(String markup) {
		return new LinkedHashMap<>();
	}

	public String getContent() {
		return content;
	}

	public String getTag() {
		return tag;
	}

	public LinkedHashMap<String, String> getAttributes() {
		return attributes;
	}

	@Override
	public String toString() {
		return "TAG: \"" + tag + "\", text: \"" + content + "\"";
	}
}
