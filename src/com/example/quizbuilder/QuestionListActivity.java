package com.example.quizbuilder;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class QuestionListActivity extends SingleFragmentActivity 
	implements QuestionListFragment.Callbacks, ConstantsInterface {
	
	@Override
	protected Fragment createFragment() {
		return new QuestionListFragment();
	}

	@Override
	protected int getLayoutResId() {
		return R.layout.activity_master_layout;
	}

	@Override
	public void onQuestionSelected(Question question) {
		if (findViewById(R.id.item_fragment_container) == null) {
			Intent intent = new Intent(this, QuestionPagerActivity.class);
			intent.putExtra(EXTRA_QUESTION_ID, question.getId());
			startActivity(intent);
		} else {
			FragmentManager manager = getSupportFragmentManager();
			FragmentTransaction transaction = manager.beginTransaction();
			
			Fragment oldItem = manager.findFragmentById(R.id.item_fragment_container);
			Fragment newItem = QuestionFragment.newInstance(question.getId());
			
			if (oldItem != null) {
				transaction.remove(oldItem);
			}
			
			transaction.add(R.id.item_fragment_container, newItem);
			transaction.commit();
		}
	}
}