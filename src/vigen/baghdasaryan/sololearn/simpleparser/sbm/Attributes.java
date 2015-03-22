package vigen.baghdasaryan.sololearn.simpleparser.sbm;

import java.util.ArrayList;

import vigen.baghdasaryan.sololearn.simpleparser.sbm.Attribute.FormatValue;
import static vigen.baghdasaryan.sololearn.simpleparser.sbm.Attribute.Name;

public class Attributes {

	private ArrayList<Attribute> attributes = null;

	public Attributes(ArrayList<Attribute> attrs) {
		attributes = attrs;
	}

	public FormatValue getFormat() {
		return get(Name.FORMAT);
	}
	
	public FormatValue get(Name key) {
		for (Attribute attr : attributes) {
			if(attr.getName() == key) {
				return attr.getValue();
			}
		}
		return FormatValue.DEFAULT;
	}
}
