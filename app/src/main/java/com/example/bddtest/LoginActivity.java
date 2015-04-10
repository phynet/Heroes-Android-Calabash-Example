package com.example.bddtest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	
	public void login(View v) {
		String username = ((EditText)findViewById(R.id.username)).getText().toString();
		String password = ((EditText)findViewById(R.id.password)).getText().toString();
		if(USERNAME.equals(username) && PASSWORD.equals(password)) {
			Intent mainIntent = new Intent(this, MainActivity.class);
			this.startActivity(mainIntent);
		} else {
			showErrorLogin();
		}
	}

	private void showErrorLogin() {
		AlertDialog errorDialog = new AlertDialog.Builder(this).create();
        errorDialog.setTitle("Error in Login");
        errorDialog.setMessage("Ups! your user or password is wrong. Try again.");
		errorDialog.setIcon(android.R.drawable.ic_dialog_alert);
		errorDialog.setCanceledOnTouchOutside(false);
		errorDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Close", new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int which) {
		    	dialog.dismiss();
		    }
		});
		errorDialog.show();
	}
	
	private final static String USERNAME = "bdd";
	private final static String PASSWORD = "1234";
	
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		
		
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_login,
					container, false);
			return rootView;
		}
		
	}

}
