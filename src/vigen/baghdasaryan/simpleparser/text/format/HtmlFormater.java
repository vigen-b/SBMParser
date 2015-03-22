package vigen.baghdasaryan.simpleparser.text.format;

import java.util.ArrayList;
import java.util.List;

import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.SourceFormatter;
import net.htmlparser.jericho.StartTag;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

public class HtmlFormater {

	public static final String INDENT_SYMBOL = "\t";
	private Spannable formattedText;
	private String htmlText = null;
	private Source source = null;
	private ArrayList<String> tags = null;

	public HtmlFormater(String html) {
		htmlText = html;
		source = new Source(html);
		tags = new ArrayList<>();
	}

	public CharSequence format() {
			findTags();
			createIndentText();
			colorizeTags();
			return formattedText;
	}

	private void findTags() {
		List<StartTag> startTagList = source.getAllStartTags();
		for (StartTag tag : startTagList) {
			tags.add(tag.getName());
		}
	}

	private void createIndentText() {
		SourceFormatter formatter = source.getSourceFormatter();
		formatter.setIndentAllElements(true);
		formatter.setIndentString(INDENT_SYMBOL);
		htmlText = formatter.toString();
	}

	private void colorizeTags() {
		formattedText = new SpannableString(htmlText);
		for (String tag : tags) {
			addSpan("<", tag);
			addSpan("</", tag);
		}
	}
	
	private void addSpan(String chars, String tag) {
		int indexOfStartTag = htmlText.indexOf(chars + tag) + chars.length();
		formattedText.setSpan(new ForegroundColorSpan(Color.GREEN),
				indexOfStartTag, indexOfStartTag + tag.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	}
}
