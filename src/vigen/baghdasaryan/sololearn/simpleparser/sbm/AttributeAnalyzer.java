package vigen.baghdasaryan.sololearn.simpleparser.sbm;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AttributeAnalyzer {

	public static final String ATTRIBUTE_PATTERN = "\\s*(?i)(.*?)\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\"\\]\\s]+))";
	private ArrayList<String> matches = null;

	public AttributeAnalyzer() {
		matches = new ArrayList<>();
	}

	public Attributes analyze(String attrs) {
		Pattern pattern = Pattern.compile(ATTRIBUTE_PATTERN);
		Matcher matcher = pattern.matcher(attrs);
		while (matcher.find()) {
			matches.add(matcher.group().trim());
		}
		return new Attributes(getAttributeList());
	}

	private ArrayList<Attribute> getAttributeList() {
		ArrayList<Attribute> attributeList = new ArrayList<>();
		for (String m : matches) {
			String[] pair = m.split("=");
			String key = pair[0];
			String value = pair[1].substring(1, pair[1].length() - 1);
			attributeList.add(new Attribute(key, value));
		}
		return attributeList;
	}
}
