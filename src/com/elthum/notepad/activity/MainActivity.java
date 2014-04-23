package com.elthum.notepad.activity;

import com.elthum.notepad.R;
import com.elthum.notepad.layout.MenuSlider;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * My main activity
 * @author Elthum
 */
public class MainActivity extends Activity {
	
	private MenuSlider menu;
	private Button hideShowButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		// Get views.
		menu = (MenuSlider)findViewById(R.id.menu);
		hideShowButton = (Button)findViewById(R.id.button_hide);
		
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
	}
}
