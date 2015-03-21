package vigen.baghdasaryan.sololearn.simpleparser.helper;

import java.text.ParseException;
import java.util.LinkedHashMap;

public class SquareBracketMarkup {
	
	public static final String LEFT_BRACKET_OF_OPEN_TAG = "[";
	public static final String LEFT_BRACKET_OF_CLOSE_TAG = "[/";
	public static final String RIGHT_BRACKET_OF_TAG = "]";
	public static final String WHITE_SPACE = " ";

	private String tag = "";
	private LinkedHashMap<String, String> attributes = null;
	private String content = "";

	public SquareBracketMarkup(String markup) throws ParseException {
		if(isMarkupValid(markup)) {
			initSquareBracketMarkup(markup, "");
		} else {
			throw new ParseException("SquareBracketML", -1);
		}
		
	}
	
	public SquareBracketMarkup(String markup, String content) throws ParseException {
		if(isMarkupValid(markup)) {
			initSquareBracketMarkup(markup, content);
		} else {
			throw new ParseException("SquareBracketML", -1);
		}
		
	}
	
	private boolean isMarkupValid(String markup) {
		int indexOfLeftBracket = markup.indexOf(LEFT_BRACKET_OF_OPEN_TAG);
		int indexOfRightBracket = markup.indexOf(RIGHT_BRACKET_OF_TAG);
		return (indexOfLeftBracket == 0 && indexOfRightBracket > 0);
	}
	
	private void initSquareBracketMarkup(String markup, String content) {
		tag = resolveTag(markup);
		attributes = resolveAttributes(markup);
		setContent(content);
	}

	private String resolveTag(String markup) {
		int endOfTag = markup.indexOf(WHITE_SPACE);
		if(endOfTag < 0) {
			endOfTag = markup.indexOf(RIGHT_BRACKET_OF_TAG);
		}
		return markup.substring(1, endOfTag);
	}

	private LinkedHashMap<String, String> resolveAttributes(String markup) {
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

	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "TAG: \"" + tag + "\", text: \"" + content + "\"";
	}
	
}
