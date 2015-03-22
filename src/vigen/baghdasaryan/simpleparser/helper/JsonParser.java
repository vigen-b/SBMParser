package vigen.baghdasaryan.simpleparser.helper;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class JsonParser {

	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String TEXT = "text";

	private JSONObject contentJson = null;
	private Context context = null;

	public JsonParser(Context context, String path) throws ParseException {
		this.context = context;
		convertFileToJson(path);
	}

	private void convertFileToJson(String path) throws ParseException {
		try {
			tryConvertFileToJson(path);
		} catch (IOException е) {
			throw new ParseException("convertFileToJson", -1);
		} catch (JSONException e) {
			throw new ParseException("convertFileToJson", -1);
		}
	}

	private void tryConvertFileToJson(String path) throws IOException,
			JSONException {
		InputStream stream = context.getAssets().open(path);
		int size = stream.available();
		byte[] buffer = new byte[size];
		stream.read(buffer);
		stream.close();
		contentJson = new JSONObject(new String(buffer, "UTF-8"));
	}

	public int getId() throws ParseException {
		return getInt(ID);
	}

	public String getName() throws ParseException {
		return get(NAME);
	}

	public String getText() throws ParseException {
		return get(TEXT);
	}

	public int getInt(String key) throws ParseException {
		try {
			return contentJson.getInt(key);
		} catch (JSONException e) {
			throw new ParseException("getInt", -1);
		}
	}

	public <K> K get(String key) throws ParseException {
		try {
			return (K) contentJson.get(key);
		} catch (JSONException e) {
			throw new ParseException("get", -1);
		} catch (ClassCastException e) {
			throw new ParseException("get", -1);
		}
	}
}
