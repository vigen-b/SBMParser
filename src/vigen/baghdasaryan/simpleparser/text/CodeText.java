package vigen.baghdasaryan.simpleparser.text;

import java.util.ArrayList;
import java.util.List;

import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.SourceFormatter;
import net.htmlparser.jericho.StartTag;
import vigen.baghdasaryan.simpleparser.R;
import vigen.baghdasaryan.simpleparser.sbm.Attribute.FormatValue;
import vigen.baghdasaryan.simpleparser.sbm.Attributes;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class CodeText extends PlainText {

	public static final String INDENT_SYMBOL = "\t";
	private FormatValue format = null;

	public CodeText(String text, Attributes attrs) {
		super(text, attrs);
		format = attrs.getFormat();
		setAsSimpleText(false);
	}

	@Override
	protected void setPropertiesToView(TextView tv) {
		Resources res = tv.getContext().getResources();
		tv.setBackgroundColor(res.getColor(R.color.code_background));
		tv.setPadding(10, 10, 10, 0);
		tv.setText(getCodeText());
	}

	private CharSequence getCodeText() {
		if (format == FormatValue.HTML) {
			return createIndentText();
		}
		return getText();
	}

	private CharSequence createIndentText() {
		Source source = new Source(getText());
		SourceFormatter formatter = source.getSourceFormatter();
		formatter.setIndentAllElements(true);
		formatter.setIndentString(INDENT_SYMBOL);
		List<StartTag> startTagList = source.getAllStartTags();
		ArrayList<String> startTags = new ArrayList<>();
		for (StartTag tag : startTagList) {
			startTags.add(tag.getName());
		}

		return colorizeTags(formatter.toString(), startTags);
	}

	private CharSequence colorizeTags(String html, ArrayList<String> tags) {
		Spannable spanText = new SpannableString(html);
		for (String tag : tags) {
			int indexOfStartTag = html.indexOf("<" + tag) + 1;
			spanText.setSpan(new ForegroundColorSpan(Color.GREEN),
					indexOfStartTag, indexOfStartTag + tag.length(),
					Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			int indexOfEndTag = html.indexOf("</" + tag) + 2;
			spanText.setSpan(new ForegroundColorSpan(Color.GREEN),
					indexOfEndTag, indexOfEndTag + tag.length(),
					Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		}
		return spanText;
	}
}
