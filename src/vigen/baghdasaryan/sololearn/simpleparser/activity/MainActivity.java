package vigen.baghdasaryan.sololearn.simpleparser.activity;

import java.text.ParseException;
import java.util.Locale;

import vigen.baghdasaryan.sololearn.simpleparser.R;
import vigen.baghdasaryan.sololearn.simpleparser.helper.JsonParser;
import vigen.baghdasaryan.sololearn.simpleparser.sbm.SBMAnalyzer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static final String SOURCE_FILE_PATH = "sample.json";

	private SBMAnalyzer analyzer = null;
	private TextView errorView = null;
	private int id = 0;
	private String name = null;
	private LinearLayout rootView = null;
	private String text = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rootView = (LinearLayout) findViewById(R.id.main_root);
		errorView = (TextView) findViewById(R.id.main_error);
		executeParsing();
	}

	private void executeParsing() {
		try {
			analyzeAndShowContent();
		} catch (ParseException e) {
			errorView.setVisibility(View.VISIBLE);
		}
	}

	private void analyzeAndShowContent() throws ParseException {
		analyzeSourceFile();
		analyzeContent();
		showContent();
		changeActionBar();
	}

	private void analyzeSourceFile() throws ParseException {
		JsonParser parser = new JsonParser(this, SOURCE_FILE_PATH);
		id = parser.getId();
		text = parser.getText();
		name = parser.getName();
	}

	private void analyzeContent() throws ParseException {
		analyzer = new SBMAnalyzer(new StringBuilder(text));
		analyzer.analyze();
	}

	private void showContent() {
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		params.setMargins(0, 10, 0, 0);
		for (View v : analyzer.getViews(getApplicationContext())) {
			rootView.addView(v, params);
		}
	}

	private void changeActionBar() {
		String title = String.valueOf(id) + ". " + name;
		getActionBar().setDisplayShowHomeEnabled(false);
		getActionBar().setTitle(title.toUpperCase(Locale.getDefault()));
	}
}
