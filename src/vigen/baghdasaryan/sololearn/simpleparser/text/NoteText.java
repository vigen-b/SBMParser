package vigen.baghdasaryan.sololearn.simpleparser.text;

import vigen.baghdasaryan.simpleparser.R;
import vigen.baghdasaryan.simpleparser.sbm.Attributes;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NoteText extends PlainText {

	public NoteText(String text, Attributes attrs) {
		super(text, attrs);
		setAsSimpleText(false);
	}
	
	@Override
	public View createView(Context context) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.note_text,
				(ViewGroup) null);
		TextView tv = (TextView) layout.findViewById(R.id.note_text);
		setPropertiesToView(tv);
		return layout;
	}
}
