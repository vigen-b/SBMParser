package vigen.baghdasaryan.sololearn.simpleparser.text;

import vigen.baghdasaryan.sololearn.simpleparser.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PlainText {

	private String text = null;

	public PlainText(String t) {
		text = t;
	}

	final public String getPlainText() {
		return text;
	}

	public View createView(Context context) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		TextView tv = (TextView) inflater.inflate(R.layout.plain_text,
				(ViewGroup) null);
		tv.setText(text);
		return tv;
	}
}
