package com.callaphony.testapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private static final int PICK_CONTACT = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button pickContactButton = (Button) findViewById(R.id.pickUpContactButton);
		pickContactButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				try {
					Intent intent = new Intent(Intent.ACTION_PICK, CommonDataKinds.Phone.CONTENT_URI);
					//intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
					startActivityForResult(intent, PICK_CONTACT);
				} catch (Exception e) {
					TextView view = (TextView) findViewById(R.id.textView1);
					view.setText(e.getMessage());
					
					//Intent intent = getIntent();
					//finish();
					//startActivity(intent);
				}
			}
		});

	}
	
	 // handle after selecting a contact from the list
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
            case PICK_CONTACT:
                // handle contact results
            	
                break;
            }
        } else {
            // gracefully handle failure
        }
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
