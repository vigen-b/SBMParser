package vigen.baghdasaryan.sololearn.simpleparser.helper;

import java.util.ArrayList;

import vigen.baghdasaryan.sololearn.simpleparser.text.PlainText;

import android.content.Context;
import android.view.View;

public class SBMViewCreator {

	private ArrayList<SBM> markupElements = null;

	public SBMViewCreator(ArrayList<SBM> elements) {
		markupElements = elements;
	}

	public ArrayList<View> create(Context context) {
		ArrayList<View> views = new ArrayList<>();
		SBM element;
		String content = "";
		int size = markupElements.size();
		for (int i = 0; i < size; i++) {
			element = markupElements.get(i);
			if (element.isSimpleMarkup()) {
				content += element.getHtml();
				if((i + 1) != size && markupElements.get(i + 1).isSimpleMarkup()) {
					continue;
				}
				PlainText text = new PlainText(content);
				views.add(text.createView(context));
			} else {
				content = "";
				views.add(element.createView(context));
			}
		}
		return views;
	}
}
