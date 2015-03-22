package vigen.baghdasaryan.simpleparser.sbm;

import java.util.Locale;

public class Attribute {
	
	private static final String FORMAT = "format";
	private static final String HTML = "html";
	
	private Name name = null;
	private FormatValue value = null;

	public Attribute(String name, String value) {
		resolveName(name.toLowerCase(Locale.getDefault()));
		resolveValue(value.toLowerCase(Locale.getDefault()));
	}
	
	private void resolveName(String name) {
		if(name.equals(FORMAT)) {
			this.name = Name.FORMAT;
		} else {
			this.name = Name.DEFAULT;
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
