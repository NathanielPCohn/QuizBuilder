package com.example.quizbuilder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public abstract class SingleFragmentActivity extends FragmentActivity {
	protected abstract Fragment createFragment();
	
	protected int getLayoutResId() {
		return R.layout.activity_master_layout;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutResId());
		
		FragmentManager manager = getSupportFragmentManager();
		Fragment fragment = manager.findFragmentById(R.id.fragment_container);
		
		if (fragment == null) {
			fragment = createFragment();
			manager.beginTransaction()
			.add(R.id.fragment_container, fragment)
			.commit();
		}
	}
}