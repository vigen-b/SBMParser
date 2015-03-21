package vigen.baghdasaryan.sololearn.simpleparser.text;

import vigen.baghdasaryan.sololearn.simpleparser.R;
import android.widget.TextView;

public class Heading1Text extends PlainText {

	public Heading1Text(String text) {
		super(text);
		setAsSimpleText(false);
	}

	@Override
	public String getHtmlText() {
		return "<h1>" + getPlainText() + "</h1>";
	}

	@Override
	protected void setPropertiesToView(TextView tv) {
		super.setPropertiesToView(tv);
		tv.setTextSize(tv.getContext().getResources()
				.getDimension(R.dimen.text_size_h1));
	}
}
