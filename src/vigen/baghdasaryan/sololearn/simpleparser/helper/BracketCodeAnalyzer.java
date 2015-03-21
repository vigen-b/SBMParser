package vigen.baghdasaryan.sololearn.simpleparser.helper;

import java.text.ParseException;
import java.util.ArrayList;
import static vigen.baghdasaryan.sololearn.simpleparser.helper.SquareBracketMarkup.*;

public class BracketCodeAnalyzer {

	private ArrayList<SquareBracketMarkup> tagos = null;

	public BracketCodeAnalyzer() {
		tagos = new ArrayList<>();
	}

	public void analyze(StringBuilder sourceText) throws ParseException {
		try {
			int startIndexOfOpenTag = sourceText
					.indexOf(LEFT_BRACKET_OF_OPEN_TAG);
			if (startIndexOfOpenTag != 0) {
				String text = sourceText.substring(0, startIndexOfOpenTag);
				tagos.add(new SquareBracketMarkup("[]", text));
				sourceText.delete(0, startIndexOfOpenTag);
			}

			int endIndexOfOpenTag = sourceText.indexOf(RIGHT_BRACKET_OF_TAG);
			String markup = sourceText.substring(0, endIndexOfOpenTag + 1);
			SquareBracketMarkup squareMarkup = new SquareBracketMarkup(markup);
			sourceText.delete(0, endIndexOfOpenTag + 1);
			int startIndexOfCloseTag = sourceText
					.indexOf(LEFT_BRACKET_OF_CLOSE_TAG + squareMarkup.getTag());
			String text = sourceText.substring(0, startIndexOfCloseTag);
			squareMarkup.setContent(text);
			tagos.add(squareMarkup);
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

	public ArrayList<SquareBracketMarkup> getTegos() {
		return tagos;
	}

}
