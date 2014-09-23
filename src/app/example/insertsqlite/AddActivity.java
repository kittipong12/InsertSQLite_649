package app.example.insertsqlite;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends Activity {

	private Button btn_add;
	private EditText edt_name, edt_age, edt_phone, edt_brithday, edt_study, edt_facebook;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add649);
		btn_add = (Button) findViewById(R.id.btnsave);
		btn_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SaveData();

			}

		});
	}

	private void SaveData() {
		edt_name = (EditText) findViewById(R.id.txtnickname);
		edt_age = (EditText) findViewById(R.id.txtage);
		edt_phone = (EditText) findViewById(R.id.txtphone);
		edt_brithday = (EditText) findViewById(R.id.txtbir);
		edt_study = (EditText) findViewById(R.id.txtstudy);
		edt_facebook = (EditText) findViewById(R.id.txtface);
		
		
		
		DB649 db649 = new DB649(this);
		long saveSatus = db649.InsertData(edt_name.getText().toString(),
				edt_age.getText().toString(), edt_phone.getText().toString(),
				edt_brithday.getText().toString(), edt_study.getText().toString(),
				edt_facebook.getText().toString());
		if(saveSatus <= 0){
			Log.d("Error Save","Error!");
			
		}
	Toast.makeText(getApplicationContext(), "Add Data Successfully", 
			Toast.LENGTH_SHORT).show();
	
	}
}
