package vigen.baghdasaryan.sololearn.simpleparser.helper;

import java.text.ParseException;
import java.util.LinkedHashMap;

import vigen.baghdasaryan.sololearn.simpleparser.text.BoldText;
import vigen.baghdasaryan.sololearn.simpleparser.text.CodeText;
import vigen.baghdasaryan.sololearn.simpleparser.text.Heading1Text;
import vigen.baghdasaryan.sololearn.simpleparser.text.NoteText;
import vigen.baghdasaryan.sololearn.simpleparser.text.PlainText;
import vigen.baghdasaryan.sololearn.simpleparser.text.UnderlineText;

import android.content.Context;
import android.view.View;

/**
 * @author vigen
 * 
 * SBM - Square Bracket Markup.
 */
public class SBM {

	public static final String LEFT_BRACKET_OF_OPEN_TAG = "[";
	public static final String LEFT_BRACKET_OF_CLOSE_TAG = "[/";
	public static final String RIGHT_BRACKET_OF_TAG = "]";
	public static final String WHITE_SPACE = " ";

	public static final String TAG_HEADING1 = "h1";
	public static final String TAG_BOLD = "b";
	public static final String TAG_UNDERLINE = "u";
	public static final String TAG_CODE = "code";
	public static final String TAG_NOTE = "note";

	private LinkedHashMap<String, String> attributes = null;
	private String content = null;
	private PlainText plainText = null;
	private String tagAsText = null;
	private String markup = null;

	public SBM(String markup, String content)
			throws ParseException {
		if (isMarkupValid(markup)) {
			initSquareBracketMarkup(markup, content);
		} else {
			throw new ParseException("SquareBracketMarkup", -1);
		}
	}

	private boolean isMarkupValid(String markup) {
		int indexOfLeftBracket = markup.indexOf(LEFT_BRACKET_OF_OPEN_TAG);
		int indexOfRightBracket = markup.indexOf(RIGHT_BRACKET_OF_TAG);
		return (indexOfLeftBracket == 0 && indexOfRightBracket > 0);
	}

	private void initSquareBracketMarkup(String markup, String content) {
		this.content = content;
		this.markup = markup;
		determineTag();
		attributes = resolveAttributes();
	}

	private void determineTag() {
		tagAsText = getTagAsText(markup);
		switch (tagAsText) {
		case TAG_HEADING1:
			plainText = new Heading1Text(content);
			break;

		case TAG_UNDERLINE:
			plainText = new UnderlineText(content);
			break;

		case TAG_BOLD:
			plainText = new BoldText(content);
			break;

		case TAG_CODE:
			plainText = new CodeText(content);
			break;

		case TAG_NOTE:
			plainText = new NoteText(content);
			break;

		default:
			plainText = new PlainText(content);
			break;
		}
	}

	private LinkedHashMap<String, String> resolveAttributes() {
		return new LinkedHashMap<>();
	}

	public static String getTagAsText(String markup) {
		int endOfTag = markup.indexOf(WHITE_SPACE);
		if (endOfTag < 0) {
			endOfTag = markup.indexOf(RIGHT_BRACKET_OF_TAG);
		}
		return markup.substring(1, endOfTag);
	}

	public View createView(Context context) {
		return plainText.createView(context);
	}

	public LinkedHashMap<String, String> getAttributes() {
		return attributes;
	}

	public String getHtml() {
		return plainText.getHtmlText();
	}

	public String getPlainText() {
		return plainText.getPlainText();
	}
	
	public boolean isSimpleMarkup() {
		return plainText.isSimpleText();
	}
}
