package app.example.insertsqlite;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class DB649 extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "mel";
	private static final String TABLE_MEMBER = "members";

	public DB649(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}

	
	


	

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TABLE_MEMBER
				+ " (MemberID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " Name TEXT (100)," + " Tel TEXT (100));");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBER);
		onCreate(db);

	}

	// INSERT

	

	// Select all data
	public ArrayList<HashMap<String, String>> SelectAllData() {
		try {
			ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map;
			SQLiteDatabase db;
			db = this.getReadableDatabase();

			String strSQL = "SELECT * FROM " + TABLE_MEMBER;
			Cursor cursor = db.rawQuery(strSQL, null);
			if (cursor != null) {
				if (cursor.moveToFirst()) {
					do {
						map = new HashMap<String, String>();
						map.put("MemberID", cursor.getString(0));
						map.put("Name", cursor.getString(1));
						map.put("Age", cursor.getString(2));
						map.put("Phone", cursor.getString(3));
						map.put("Birthday", cursor.getString(4));
						map.put("Study", cursor.getString(5));
						map.put("Facebook", cursor.getString(6));
						
						arrayList.add(map);

					} while (cursor.moveToNext());
				}
			}
			cursor.close();
			db.close();
			return arrayList;

		} catch (Exception e) {
			return null;
		}

	}


	public long InsertData(String strnickname, String strage, String strphone,
			String strbirthday, String strstudy, String strfacebook) {
		
		try {
			SQLiteDatabase db;
			db = getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put("Name", strnickname);
			values.put("Age", strage);
			values.put("Phone", strage);
			values.put("Birthday", strage);
			values.put("Study", strage);
			values.put("Facebook", strage);

			long l = db.insert(TABLE_MEMBER, null, values);
			db.close();
			return l;

		} catch (Exception e) {

		}
		return -1;

	}
}
