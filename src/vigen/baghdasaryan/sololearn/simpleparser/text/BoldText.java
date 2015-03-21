package vigen.baghdasaryan.sololearn.simpleparser.text;

import android.graphics.Typeface;
import android.widget.TextView;

public class BoldText extends PlainText {
	
	public static final String BOLD_START_TAG = "<b>";
	public static final String BOLD_END_TAG = "</b>";

	public BoldText(String text) {
		super(text);
	}
	
	@Override
	public String getHtmlText() {
		return BOLD_START_TAG + getPlainText() + BOLD_END_TAG;
	}

	@Override
	protected void setPropertiesToView(TextView tv) {
		super.setPropertiesToView(tv);
		tv.setTypeface(null, Typeface.BOLD);
	}
}
