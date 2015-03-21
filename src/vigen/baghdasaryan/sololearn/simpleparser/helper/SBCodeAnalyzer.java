package vigen.baghdasaryan.sololearn.simpleparser.helper;

import static vigen.baghdasaryan.sololearn.simpleparser.helper.SBM.LEFT_BRACKET_OF_CLOSE_TAG;
import static vigen.baghdasaryan.sololearn.simpleparser.helper.SBM.LEFT_BRACKET_OF_OPEN_TAG;
import static vigen.baghdasaryan.sololearn.simpleparser.helper.SBM.RIGHT_BRACKET_OF_TAG;
import static vigen.baghdasaryan.sololearn.simpleparser.helper.SBM.determineTagAsText;

import java.text.ParseException;
import java.util.ArrayList;

import android.content.Context;
import android.view.View;

/**
 * @author vigen
 *
 * SB - Square Bracket ("[]").
 */
public class SBCodeAnalyzer {

	private ArrayList<SBM> markupElements = null;

	public SBCodeAnalyzer() {
		markupElements = new ArrayList<>();
	}

	public void analyze(StringBuilder sourceText) throws ParseException {
		try {
			int startIndexOfOpenTag = sourceText
					.indexOf(LEFT_BRACKET_OF_OPEN_TAG);
			if (startIndexOfOpenTag != 0) {
				String text = sourceText.substring(0, startIndexOfOpenTag);
				markupElements.add(new SBM("[]", text));
				sourceText.delete(0, startIndexOfOpenTag);
			}

			int endIndexOfOpenTag = sourceText.indexOf(RIGHT_BRACKET_OF_TAG);
			String markup = sourceText.substring(0, endIndexOfOpenTag + 1);
			sourceText.delete(0, endIndexOfOpenTag + 1);
			int startIndexOfCloseTag = sourceText
					.indexOf(LEFT_BRACKET_OF_CLOSE_TAG
							+ determineTagAsText(markup));
			String text = sourceText.substring(0, startIndexOfCloseTag);
			SBM element = new SBM(markup, text);
			markupElements.add(element);
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

	public ArrayList<View> getViews(Context context) {
		SBMViewCreator viewCreator = new SBMViewCreator(markupElements);
		return viewCreator.create(context);
	}

}
