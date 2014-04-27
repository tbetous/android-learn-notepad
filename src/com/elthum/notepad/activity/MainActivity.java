package com.elthum.notepad.activity;

import com.elthum.notepad.R;
import com.elthum.notepad.layout.MenuSlider;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

/**
 * My main activity
 * @author Elthum
 */
public class MainActivity extends Activity {
	
	private MenuSlider menu;
	private Button hideShowButton;
	private RadioGroup colors;

	private EditText edition;
	private TextView preview;
	private String color = "#000000";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		// Get views.
		menu = (MenuSlider)findViewById(R.id.menu);
		hideShowButton = (Button)findViewById(R.id.button_hide);
		colors = (RadioGroup)findViewById(R.id.colors);
		edition = (EditText)findViewById(R.id.editText_edition);
		preview = (TextView)findViewById(R.id.textView_preview);
		
		
		// Set hide button listener.
		hideShowButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(menu.isOpen()) {
					hideShowButton.setText(getResources().getString(R.string.button_show_menu));
				} else {
					hideShowButton.setText(getResources().getString(R.string.button_hide_menu));
				}
				menu.toogle();
			}
		});
		
		// Set group color listener in order to change the variable color when the user want to switch.
		colors.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
					case R.id.button_black: color = getResources().getString(R.string.black);
						break;
					case R.id.button_blue: color = getResources().getString(R.string.blue);
						break;
					case R.id.button_red: color = getResources().getString(R.string.red);		
						break;
					default: color = getResources().getString(R.string.black);
				}
				preview.setText(Html.fromHtml("<font color=\"" + color + "\">" + edition.getText().toString() + "</span>"));
			}
		});
		
		// Set a textwatcher in order to update the text into the previewer.
		edition.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				preview.setText(Html.fromHtml("<font color=\"" + color + "\">" + edition.getText().toString() + "</span>"));
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {				
			}
			
			@Override
			public void afterTextChanged(Editable s) {				
			}
		});
	}
}
