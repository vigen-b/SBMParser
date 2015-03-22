package vigen.baghdasaryan.sololearn.simpleparser.sbm;

import java.util.Locale;

public class Attribute {
	
	private static final String FORMAT = "format";
	private static final String HTML = "html";
	
	private Name name = null;
	private FormatValue value = null;

	public Attribute(String key, String value) {
		resolveKey(key.toLowerCase(Locale.getDefault()));
		resolveValue(value.toLowerCase(Locale.getDefault()));
	}
	
	private void resolveKey(String key) {
		if(key.equals(FORMAT)) {
			name = Name.FORMAT;
		} else {
			name = Name.DEFAULT;
		}
	}
	
	private void resolveValue(String val) {
		if(val.equals(HTML)) {
			value = FormatValue.HTML;
		} else {
			value = FormatValue.DEFAULT;
		}
	}
	
	public Name getName() {
		return name;
	}
	
	public FormatValue getValue() {
		return value;
	}
	
	public enum Name {
		DEFAULT, FORMAT;
	}

	public enum FormatValue {
		DEFAULT, HTML;
	}
}
