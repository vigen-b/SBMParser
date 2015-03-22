package vigen.baghdasaryan.sololearn.simpleparser.text;

import vigen.baghdasaryan.simpleparser.R;
import vigen.baghdasaryan.simpleparser.sbm.Attributes;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PlainText {

	private Attributes attributes = null;
	private boolean isSimpleText = true;
	private String text = null;

	public PlainText(String text, Attributes attrs) {
		attributes = attrs;
		this.text = text;
	}

	public View createView(Context context) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		TextView tv = (TextView) inflater.inflate(R.layout.plain_text,
				(ViewGroup) null);
		setPropertiesToView(tv);
		return tv;
	}

	protected void setPropertiesToView(TextView tv) {
		tv.setText(Html.fromHtml(text));
	}

	public Attributes getAttributes() {
		return attributes;
	}
	
	public String getHtml() {
		return text;
	}

	final public String getText() {
		return text;
	}

	public boolean isSimpleText() {
		return isSimpleText;
	}

	protected void setAsSimpleText(boolean isSimpleText) {
		this.isSimpleText = isSimpleText;
	}
}
