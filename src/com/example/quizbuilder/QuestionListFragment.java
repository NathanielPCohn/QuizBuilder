package com.example.quizbuilder;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class QuestionListFragment extends ListFragment 
implements ConstantsInterface {
	private ArrayList<Question> questionSet;
	private Callbacks callbacks;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.generic_quiz_title);
		setHasOptionsMenu(false);
		
		questionSet = Quiz.getInstance().getQuestionSet();
		
		QuizAdapter adapter = new QuizAdapter(questionSet);
		setListAdapter(adapter);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		View view = inflater.inflate(R.layout.fragment_question_list, 
				container, false);
		return view;
	}
	
	@Override
	public void onListItemClick(ListView listview, View view, int position, long id) {
		super.onListItemClick(listview, view, position, id);
		
		Question question = (Question)(getListAdapter()).getItem(position);
		callbacks.onQuestionSelected(question);
	}

	public interface Callbacks {
		void onQuestionSelected(Question question);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		callbacks = (Callbacks)activity;
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		callbacks = null;
	}

	private class QuizAdapter extends ArrayAdapter<Question> {
		public QuizAdapter(ArrayList<Question> questionSet) {
			super(getActivity(), 0, questionSet);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.list_item_question, null);
			}
			
			Question question = getItem(position);
			
			TextView questionText = (TextView)convertView
					.findViewById(R.id.list_item_question_text);
			questionText.setText(question.getQuestion());
			
			return convertView;
		}	
	}
}