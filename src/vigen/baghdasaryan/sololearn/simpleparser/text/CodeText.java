package vigen.baghdasaryan.sololearn.simpleparser.text;

import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.SourceFormatter;
import vigen.baghdasaryan.sololearn.simpleparser.R;
import vigen.baghdasaryan.sololearn.simpleparser.sbm.Attribute.FormatValue;
import vigen.baghdasaryan.sololearn.simpleparser.sbm.Attributes;
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
			return createIndentText();
		}
		return getText();
	}

	private CharSequence createIndentText() {
		Source source = new Source(getText());
		SourceFormatter formatter = source.getSourceFormatter();
		formatter.setIndentAllElements(true);
		formatter.setIndentString(INDENT_SYMBOL);
		return formatter.toString();
	}
}
