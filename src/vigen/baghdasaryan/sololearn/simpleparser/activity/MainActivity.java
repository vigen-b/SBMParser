package vigen.baghdasaryan.sololearn.simpleparser.activity;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

import vigen.baghdasaryan.sololearn.simpleparser.R;
import vigen.baghdasaryan.sololearn.simpleparser.helper.BracketCodeAnalyzer;
import vigen.baghdasaryan.sololearn.simpleparser.helper.JsonParser;
import vigen.baghdasaryan.sololearn.simpleparser.helper.SquareBracketML;
import vigen.baghdasaryan.sololearn.simpleparser.text.PlainText;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static final String SOURCE_FILE_PATH = "sample.json";

	private LinearLayout root = null;
	private TextView errorView = null;
	private String name = "";
	private String text = "";
	private int id = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		root = (LinearLayout) findViewById(R.id.main_root);
		errorView = (TextView) findViewById(R.id.main_error);
		showSourceContent();
	}

	private void showSourceContent() {
		try {
			parseSourceFile();
			analyzeSource();
			changeActionBar();
		} catch (ParseException e) {
			errorView.setVisibility(View.VISIBLE);
		}
	}
	
	private void analyzeSource() throws ParseException {
		BracketCodeAnalyzer analyzer = new BracketCodeAnalyzer();
		analyzer.analyze(new StringBuilder(text));
		ArrayList<SquareBracketML> tagos = analyzer.getTegos();
		for (SquareBracketML tag : tagos) {
			PlainText text = new PlainText(tag.getContent());
			TextView tv = (TextView) text.createView(getApplicationContext());
			root.addView(tv);
		}
	}

	private void parseSourceFile() throws ParseException {
		JsonParser parser = new JsonParser(this, SOURCE_FILE_PATH);
		id = parser.getId();
		text = parser.getText();
		name = parser.getName();
	}

	private void changeActionBar() {
		String title = String.valueOf(id) + ". " + name;
		getActionBar().setDisplayShowHomeEnabled(false);
		getActionBar().setTitle(title.toUpperCase(Locale.getDefault()));
	}
}
