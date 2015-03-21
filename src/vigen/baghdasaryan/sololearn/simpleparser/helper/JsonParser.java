package vigen.baghdasaryan.sololearn.simpleparser.helper;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class JsonParser {

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String TEXT = "text";
	
	private JSONObject contentJson = null;
	private Context context = null;

	public JsonParser(Context context, String path) throws ParseException {
		this.context = context;
		contentJson = getJsonFromSourceFile(path);
	}

	private JSONObject getJsonFromSourceFile(String path) throws ParseException {
		try {
			InputStream stream = context.getAssets().open(path);
			int size = stream.available();
			byte[] buffer = new byte[size];
			stream.read(buffer);
			stream.close();
			String content = new String(buffer, "UTF-8");
			return new JSONObject(content);
		} catch (IOException е) {
			throw new ParseException("getJsonFromSourceFile", -1);
		} catch (JSONException e) {
			throw new ParseException("getJsonFromSourceFile", -1);
		}
	}

	public int getId() throws ParseException {
		try {
			return contentJson.getInt(ID);
		} catch (JSONException e) {
			throw new ParseException("getID", -1);
		}
	}

	public String getText() throws ParseException {
		try {
			return contentJson.getString(TEXT);
		} catch (JSONException e) {
			throw new ParseException("getText", -1);
		}
	}

	public String getName() throws ParseException {
		try {
			return contentJson.getString(NAME);
		} catch (JSONException e) {
			throw new ParseException("getName", -1);
		}
	}

}
