package vigen.baghdasaryan.simpleparser.text;

import vigen.baghdasaryan.simpleparser.sbm.Attributes;
import android.graphics.Typeface;
import android.widget.TextView;

public class BoldText extends PlainText {
	
	public static final String BOLD_START_TAG = "<b>";
	public static final String BOLD_END_TAG = "</b>";

	public BoldText(String text, Attributes attrs) {
		super(text, attrs);
	}
	
	@Override
	public String getHtml() {
		return BOLD_START_TAG + getText() + BOLD_END_TAG;
	}

	@Override
	protected void setPropertiesToView(TextView tv) {
		super.setPropertiesToView(tv);
		tv.setTypeface(null, Typeface.BOLD);
	}
}
