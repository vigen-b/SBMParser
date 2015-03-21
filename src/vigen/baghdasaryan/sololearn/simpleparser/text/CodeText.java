package vigen.baghdasaryan.sololearn.simpleparser.text;

import android.widget.TextView;

public class CodeText extends PlainText {

	public CodeText(String text) {
		super(text);
		setAsSimpleText(false);
	}

	@Override
	protected void setPropertiesToView(TextView tv) {
		tv.setText(getPlainText());
	}
}
