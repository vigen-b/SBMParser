package vigen.baghdasaryan.simpleparser.sbm;

import java.text.ParseException;

import vigen.baghdasaryan.simpleparser.helper.PlainTextFactory;
import vigen.baghdasaryan.sololearn.text.PlainText;
import android.content.Context;
import android.view.View;

/**
 * SBM - Square Bracket Markup.
 * 
 * @author vigen
 */
public class SBM {

	public static final String SBM_BRACKETS = "[]";
	public static final String LEFT_BRACKET_OF_OPEN_TAG = "[";
	public static final String LEFT_BRACKET_OF_CLOSE_TAG = "[/";
	public static final String RIGHT_BRACKET_OF_TAG = "]";
	public static final String WHITE_SPACE = " ";

	private PlainText plainText = null;
	private String tag = null;

	public SBM(String markup, String content) throws ParseException {
		if (isMarkupValid(markup)) {
			initSquareBracketMarkup(markup, content);
		} else {
			throw new ParseException("SBM", -1);
		}
	}

	private boolean isMarkupValid(String markup) {
		int indexOfLeftBracket = markup.indexOf(LEFT_BRACKET_OF_OPEN_TAG);
		int indexOfRightBracket = markup.indexOf(RIGHT_BRACKET_OF_TAG);
		return (indexOfLeftBracket == 0 && indexOfRightBracket > 0);
	}

	private void initSquareBracketMarkup(String markup, String content) {
		tag = getTag(markup);
		Attributes attributes = getAttributes(markup);
		PlainTextFactory factory = new PlainTextFactory(content, tag,
				attributes);
		plainText = factory.getPlainText();
	}

	public static String getTag(String markup) {
		int endOfTag = markup.indexOf(WHITE_SPACE);
		if (endOfTag < 0) {
			endOfTag = markup.indexOf(RIGHT_BRACKET_OF_TAG);
		}
		return markup.substring(1, endOfTag);
	}

	private Attributes getAttributes(String markup) {
		AttributeAnalyzer analyzer = new AttributeAnalyzer();
		String markupWithoutParenthesis = markup.substring(1,
				markup.length() - 1);
		String attributes = markupWithoutParenthesis.substring(tag.length());
		return analyzer.analyze(attributes);
	}

	public View createView(Context context) {
		return plainText.createView(context);
	}

	public String getHtml() {
		return plainText.getHtml();
	}

	public String getPlainText() {
		return plainText.getText();
	}

	public boolean isSimpleMarkup() {
		return plainText.isSimpleText();
	}
}
