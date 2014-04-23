package com.elthum.notepad.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

/**
 * This is a custom layout in order to slide a menu.
 * @author Elthum
 *
 */
public class MenuSlider extends RelativeLayout {
	
	// The speed of the animation in millisecond.
	public static int SPEED = 500;
	
	// The animation whose the aim is to slide the menu.
	private TranslateAnimation animation = null;
	
	// Used to know the status of the menu.
	private boolean isOpen = true;

	public MenuSlider(Context context) {
		super(context);
	}
	
	public MenuSlider(Context context, AttributeSet attr) {
		super(context, attr);
	}
	
	/**
	 * Getter of the attribute isOpen. Allows to know if the menu is open or not.
	 * @return The status of the menu.
	 */
	public boolean isOpen() {
		return isOpen;
	}

	/**
	 * Allows to open or close the menu.
	 */
	public void toogle() {
		if(isOpen == true) {
			animation = new TranslateAnimation(0, 0, 0, -getHeight());
			animation.setAnimationListener(hideMenuListener);
		} else {
			animation = new TranslateAnimation(0, 0, -getHeight(), 0);
			animation.setAnimationListener(showMenuListener);
		}
		isOpen = !isOpen;
		animation.setDuration(SPEED);
		animation.setFillAfter(true);
		startAnimation(animation);
	}
	
	/**
	 * Listener linked with the animation when the menu.
	 */
	public AnimationListener hideMenuListener = new AnimationListener() {
		@Override
		public void onAnimationStart(Animation animation) {
						
		}
		
		@Override
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onAnimationEnd(Animation animation) {
			setVisibility(View.GONE);
		}
	};
	
	/**
	 * Listener linked with the animation when the menu is opening.
	 */
	public AnimationListener showMenuListener = new AnimationListener() {
		@Override
		public void onAnimationStart(Animation animation) {
			setVisibility(View.VISIBLE);
		}
		
		@Override
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onAnimationEnd(Animation animation) {
		}
	};
	
}
