package vigen.baghdasaryan.sololearn.simpleparser.text;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class UnderlineText extends PlainText {
	
	public static final String UNDERLINE_START_TAG = "<u>";
	public static final String UNDRLINE_END_TAG = "</u>";

	public UnderlineText(String text) {
		super(text);
	}
	
	@Override
	public String getHtmlText() {
		return UNDERLINE_START_TAG + getPlainText() + UNDRLINE_END_TAG;
	}
	
	@Override
	protected void setPropertiesToView(TextView tv) {
		SpannableString content = new SpannableString(getPlainText());
		content.setSpan(new UnderlineSpan(), 0, getPlainText().length(), 0);
		tv.setText(content);
	}

}
