package vigen.baghdasaryan.simpleparser.text;

import vigen.baghdasaryan.simpleparser.R;
import vigen.baghdasaryan.simpleparser.sbm.Attributes;
import android.widget.TextView;

public class HeadingText extends PlainText {

	public HeadingText(String text, Attributes attrs) {
		super(text, attrs);
		setAsSimpleText(false);
	}

	@Override
	public String getHtml() {
		return "<h1>" + getText() + "</h1>";
	}

	@Override
	protected void setPropertiesToView(TextView tv) {
		super.setPropertiesToView(tv);
		tv.setTextSize(tv.getContext().getResources()
				.getDimension(R.dimen.text_size_h1));
	}
}
