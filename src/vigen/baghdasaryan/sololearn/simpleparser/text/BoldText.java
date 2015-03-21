package vigen.baghdasaryan.sololearn.simpleparser.text;

import android.graphics.Typeface;
import android.widget.TextView;

public class BoldText extends PlainText {

	public BoldText(String text) {
		super(text);
	}
	
	@Override
	public String getHtmlText() {
		return "<b>" + getPlainText() + "</b>";
	}

	@Override
	protected void setPropertiesToView(TextView tv) {
		super.setPropertiesToView(tv);
		tv.setTypeface(null, Typeface.BOLD);
	}
}
