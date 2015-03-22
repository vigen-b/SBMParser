package vigen.baghdasaryan.simpleparser.sbm;

import java.util.ArrayList;

import vigen.baghdasaryan.simpleparser.sbm.Attribute.FormatValue;
import static vigen.baghdasaryan.simpleparser.sbm.Attribute.Name;

public class Attributes {

	private ArrayList<Attribute> attributes = null;

	public Attributes(ArrayList<Attribute> attrs) {
		attributes = attrs;
	}

	public FormatValue getFormat() {
		return get(Name.FORMAT);
	}
	
	public FormatValue get(Name name) {
		for (Attribute attr : attributes) {
			if(attr.getName() == name) {
				return attr.getValue();
			}
		}
		return FormatValue.DEFAULT;
	}
}
