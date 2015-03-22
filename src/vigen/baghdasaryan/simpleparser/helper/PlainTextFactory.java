package vigen.baghdasaryan.simpleparser.helper;

import vigen.baghdasaryan.simpleparser.sbm.Attributes;
import vigen.baghdasaryan.simpleparser.text.BoldText;
import vigen.baghdasaryan.simpleparser.text.CodeText;
import vigen.baghdasaryan.simpleparser.text.HeadingText;
import vigen.baghdasaryan.simpleparser.text.NoteText;
import vigen.baghdasaryan.simpleparser.text.PlainText;
import vigen.baghdasaryan.simpleparser.text.UnderlineText;

public class PlainTextFactory {

	public static final String TAG_HEADING = "h1";
	public static final String TAG_BOLD = "b";
	public static final String TAG_UNDERLINE = "u";
	public static final String TAG_CODE = "code";
	public static final String TAG_NOTE = "note";

	private Attributes attributes = null;
	private String content = null;
	private PlainText plainText = null;
	private String tag = null;

	public PlainTextFactory(String content, String tag, Attributes attrs) {
		attributes = attrs;
		this.content = content;
		this.tag = tag;
		createPlainText();
	}

	private void createPlainText() {
		switch (tag) {
		case TAG_HEADING:
			plainText = new HeadingText(content, attributes);
			break;
		case TAG_UNDERLINE:
			plainText = new UnderlineText(content, attributes);
			break;
		case TAG_BOLD:
			plainText = new BoldText(content, attributes);
			break;
		case TAG_CODE:
			plainText = new CodeText(content, attributes);
			break;
		case TAG_NOTE:
			plainText = new NoteText(content, attributes);
			break;
		default:
			plainText = new PlainText(content, attributes);
			break;
		}
	}

	public PlainText getPlainText() {
		return plainText;
	}
}
