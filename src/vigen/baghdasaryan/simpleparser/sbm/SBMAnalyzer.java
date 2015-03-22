package vigen.baghdasaryan.simpleparser.sbm;

import static vigen.baghdasaryan.simpleparser.sbm.SBM.*;

import java.text.ParseException;
import java.util.ArrayList;


import android.content.Context;
import android.view.View;

public class SBMAnalyzer {

	private ArrayList<SBM> markupElements = null;
	private StringBuilder sample = null;

	public SBMAnalyzer(StringBuilder markupCode) {
		markupElements = new ArrayList<>();
		sample = markupCode;
	}

	public void analyze() throws ParseException {
		try {
			addMarkupElementAndRemoveFromSample();
		} catch (StringIndexOutOfBoundsException e) {
			throw new ParseException("analyze", -1);
		}
	}

	private void addMarkupElementAndRemoveFromSample()
			throws StringIndexOutOfBoundsException, ParseException {
		int indexOfLeftBracket = sample.indexOf(LEFT_BRACKET_OF_OPEN_TAG);
		if (indexOfLeftBracket != 0) {
			addElementAndRemoveText(indexOfLeftBracket, SBM_BRACKETS);
		}
		String markup = deleteNextMarkup();
		indexOfLeftBracket = sample.indexOf(LEFT_BRACKET_OF_CLOSE_TAG
				+ getTag(markup));
		addElementAndRemoveText(indexOfLeftBracket, markup);
		deleteNextMarkup();
		if (sample.length() != 0) {
			analyze();
		}
	}

	private void addElementAndRemoveText(int endIndex, String markup)
			throws ParseException {
		String text = sample.substring(0, endIndex);
		markupElements.add(new SBM(markup, text));
		sample.delete(0, endIndex);
	}

	private String deleteNextMarkup() {
		int indexOfRightBracket = sample.indexOf(RIGHT_BRACKET_OF_TAG);
		String markup = sample.substring(0, indexOfRightBracket + 1);
		sample.delete(0, indexOfRightBracket + 1);
		return markup;
	}

	public ArrayList<View> getViews(Context context) {
		SBMViewCreator viewCreator = new SBMViewCreator(markupElements);
		return viewCreator.create(context);
	}
}
