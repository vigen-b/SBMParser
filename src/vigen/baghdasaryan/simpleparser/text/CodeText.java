package vigen.baghdasaryan.simpleparser.text;

import vigen.baghdasaryan.simpleparser.R;
import vigen.baghdasaryan.simpleparser.sbm.Attribute.FormatValue;
import vigen.baghdasaryan.simpleparser.sbm.Attributes;
import vigen.baghdasaryan.simpleparser.text.format.HtmlFormater;
import android.content.res.Resources;
import android.widget.TextView;

public class CodeText extends PlainText {

	public static final String INDENT_SYMBOL = "\t";
	private FormatValue format = null;

	public CodeText(String text, Attributes attrs) {
		super(text, attrs);
		format = attrs.getFormat();
		setAsSimpleText(false);
	}

	@Override
	protected void setPropertiesToView(TextView tv) {
		Resources res = tv.getContext().getResources();
		tv.setBackgroundColor(res.getColor(R.color.code_background));
		tv.setPadding(10, 10, 10, 0);
		tv.setText(getCodeText());
	}

	private CharSequence getCodeText() {
		if (format == FormatValue.HTML) {
			return createHtmlFormat();
		}
		return getText();
	}

	public CharSequence createHtmlFormat() {
		return new HtmlFormater(getText()).format();
	}
}
