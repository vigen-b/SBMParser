package vigen.baghdasaryan.sololearn.simpleparser.text;

import vigen.baghdasaryan.sololearn.simpleparser.R;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PlainText {

	private String text = null;
	private boolean isSimpleText = true;

	public PlainText(String text) {
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

	public String getHtmlText() {
		return text;
	}

	final public String getPlainText() {
		return text;
	}

	public boolean isSimpleText() {
		return isSimpleText;
	}

	protected void setAsSimpleText(boolean isSimpleText) {
		this.isSimpleText = isSimpleText;
	}
}
