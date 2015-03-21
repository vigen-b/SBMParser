package vigen.baghdasaryan.sololearn.simpleparser.text;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class UnderlineText extends PlainText {

	public UnderlineText(String text) {
		super(text);
	}
	
	@Override
	public String getHtmlText() {
		return "<u>" + getPlainText() + "</u>";
	}
	
	@Override
	protected void setPropertiesToView(TextView tv) {
		SpannableString content = new SpannableString(getPlainText());
		content.setSpan(new UnderlineSpan(), 0, getPlainText().length(), 0);
		tv.setText(content);
	}

}
