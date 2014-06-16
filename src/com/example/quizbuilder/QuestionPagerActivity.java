package com.example.quizbuilder;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class QuestionPagerActivity extends FragmentActivity 
	implements ConstantsInterface {
	private ViewPager viewPager;
	private ArrayList<Question> questionSet;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		viewPager = new ViewPager(this);
		viewPager.setId(R.id.viewPager);
		setContentView(viewPager);
		
		questionSet = Quiz.getInstance().getQuestionSet();
		
		FragmentManager manager = getSupportFragmentManager();
		viewPager.setAdapter(new FragmentStatePagerAdapter(manager){

			@Override
			public Fragment getItem(int pos) {
				Question question = questionSet.get(pos);
				return QuestionFragment.newInstance(question.getId());
			}

			@Override
			public int getCount() {
				return questionSet.size();
			}
		});
		
		viewPager.setOnPageChangeListener(new ViewPager
				.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int pos) {
				Question question = questionSet.get(pos);
				if (question.getQuestion() != null) {
					setTitle(question.getQuestion());
				}
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) { }
			
			@Override
			public void onPageScrollStateChanged(int arg0) { }
		});
	}
}
