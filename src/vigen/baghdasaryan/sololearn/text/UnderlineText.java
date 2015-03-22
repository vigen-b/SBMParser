package vigen.baghdasaryan.sololearn.text;

import vigen.baghdasaryan.simpleparser.sbm.Attributes;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class UnderlineText extends PlainText {
	
	public static final String UNDERLINE_START_TAG = "<u>";
	public static final String UNDRLINE_END_TAG = "</u>";

	public UnderlineText(String text, Attributes attrs) {
		super(text, attrs);
	}
	
	@Override
	public String getHtml() {
		return UNDERLINE_START_TAG + getText() + UNDRLINE_END_TAG;
	}
	
	@Override
	protected void setPropertiesToView(TextView tv) {
		SpannableString content = new SpannableString(getText());
		content.setSpan(new UnderlineSpan(), 0, getText().length(), 0);
		tv.setText(content);
	}
}
