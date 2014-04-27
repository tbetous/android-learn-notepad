package com.elthum.notepad.activity;

import com.elthum.notepad.R;
import com.elthum.notepad.layout.MenuSlider;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
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
	private Button boldButton;
	private Button italicButton;
	private Button underlineButton;
	private RadioGroup colors;
	private EditText edition;
	private TextView preview;
	
	private String color = "#000000";
	private Boolean bold = false;
	private Boolean italic = false;
	private Boolean underline = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		// Get views.
		menu = (MenuSlider)findViewById(R.id.menu);
		hideShowButton = (Button)findViewById(R.id.button_hide);
		boldButton = (Button)findViewById(R.id.button_bold);
		italicButton = (Button)findViewById(R.id.button_italic);
		underlineButton = (Button)findViewById(R.id.button_underline);
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
		
		// Set bold button listener.
		boldButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Button button = (Button) view;
				if(bold == true) {
					button.setBackgroundResource(R.drawable.blue_button_base);
				} else {
					button.setBackgroundResource(R.drawable.green_button_base);
				}
				bold = !bold;
				preview.setText(computeText(edition.getText().toString()));
			}
		});
		
		// Set italic button listener.
		italicButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Button button = (Button) view;
				if(italic == true) {
					button.setBackgroundResource(R.drawable.blue_button_base);
				} else {
					button.setBackgroundResource(R.drawable.green_button_base);
				}
				italic = !italic;
				preview.setText(computeText(edition.getText().toString()));
			}
		});
		
		// Set underline button listener.
		underlineButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Button button = (Button) view;
				if(underline == true) {
					button.setBackgroundResource(R.drawable.blue_button_base);
				} else {
					button.setBackgroundResource(R.drawable.green_button_base);
				}
				underline = !underline;
				preview.setText(computeText(edition.getText().toString()));
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
				preview.setText(computeText(edition.getText().toString()));
			}
		});
		
		// Set a Textwatcher in order to update the text into the previewer.
		edition.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				preview.setText(computeText(edition.getText().toString()));
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
	
	/**
	 * Allows to compute a text into html spanned text
	 * @param text Text to compute
	 * @return The html spanned text.
	 */
	private Spanned computeText(CharSequence text) {
		StringBuilder sb = new StringBuilder(text);
		if (bold == true) {
			sb.insert(0, "<b>").append("</b>");
		}
		if (italic == true) {
			sb.insert(0, "<i>").append("</i>");
		}
		if (underline == true) {
			sb.insert(0, "<u>").append("</u>");
		}
		return Html.fromHtml("<font color=\"" + color + "\">" + sb.toString() + "</span>");
	}
}
