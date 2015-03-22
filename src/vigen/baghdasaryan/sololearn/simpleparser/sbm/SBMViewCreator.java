package vigen.baghdasaryan.sololearn.simpleparser.sbm;

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
		String content = "";
		ArrayList<View> views = new ArrayList<>();
		
		for (int i = 0; i < markupElements.size(); i++) {
			if (isSimpleMarkup(i)) {
				content += markupElements.get(i).getHtml();
				if(isSimpleMarkup(i + 1)) {
					continue;
				}
				PlainText text = new PlainText(content, null);
				views.add(text.createView(context));
			} else {
				views.add(markupElements.get(i).createView(context));
				content = "";
			}
		}
		return views;
	}
	
	private boolean isSimpleMarkup(int i) {
		int size = markupElements.size();
		return i < size && markupElements.get(i).isSimpleMarkup();
	}
}
