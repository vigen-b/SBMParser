package vigen.baghdasaryan.sololearn.simpleparser.helper;

import java.text.ParseException;
import java.util.ArrayList;

public class BracketCodeAnalyzer {

	public static final String LEFT_BRACKET_OF_OPEN_TAG = "[";
	public static final String LEFT_BRACKET_OF_CLOSE_TAG = "[/";
	public static final String RIGHT_BRACKET_OF_TAG = "]";

	private ArrayList<SquareBracketML> tagos = null;

	public BracketCodeAnalyzer() {
		tagos = new ArrayList<>();
	}

	public void analyze(StringBuilder sourceText) throws ParseException {
		try {
			int startIndexOfOpenTag = sourceText
					.indexOf(LEFT_BRACKET_OF_OPEN_TAG);
			if (startIndexOfOpenTag != 0) {
				String text = sourceText.substring(0, startIndexOfOpenTag);
				tagos.add(new SquareBracketML("", text)); // put("default",
															// text);
				sourceText.delete(0, startIndexOfOpenTag);
			}

			String tag = sourceText.substring(1,
					Math.min(sourceText.indexOf(" "), sourceText.indexOf("]")));
			int endIndexOfOpenTag = sourceText.indexOf(RIGHT_BRACKET_OF_TAG);
			sourceText.delete(0, endIndexOfOpenTag + 1);
			int startIndexOfCloseTag = sourceText
					.indexOf(LEFT_BRACKET_OF_CLOSE_TAG + tag);
			String text = sourceText.substring(0, startIndexOfCloseTag);
			tagos.add(new SquareBracketML(tag, text));
			sourceText.delete(0, startIndexOfCloseTag);
			int endIndexOfCloseTag = sourceText.indexOf(RIGHT_BRACKET_OF_TAG);
			sourceText.delete(0, endIndexOfCloseTag + 1);
			if (sourceText.length() != 0) {
				analyze(sourceText);
			}
		} catch (StringIndexOutOfBoundsException e) {
			throw new ParseException("analyze", -1);
		}
	}

	public ArrayList<SquareBracketML> getTegos() {
		return tagos;
	}

}
