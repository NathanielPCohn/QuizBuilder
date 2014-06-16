package com.example.quizbuilder;

import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionFragment extends Fragment 
	implements ConstantsInterface {
	private Question question;
	
	public static QuestionFragment newInstance(UUID id) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_QUESTION_ID, id);
		QuestionFragment fragment = new QuestionFragment();
		fragment.setArguments(args);
		
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		UUID id = null;
		
		if(getArguments() == null) {
			id = (UUID) getActivity().getIntent()
					.getSerializableExtra(EXTRA_QUESTION_ID);
		} else {
			id = (UUID) getArguments().getSerializable(EXTRA_QUESTION_ID);
		}
		
		question = Quiz.getInstance().getQuestion(id);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_question, container, false);
		
		initQuestion(view);
		initAnswers(view);
		
		return view;
	}
	
	public void initQuestion(View view) {
		TextView questionText = (TextView)view.findViewById(R.id.question_text_view);
		questionText.setText(question.getQuestion());
	}
	
	public void initAnswers(View view) {
		RadioGroup answerGroup = (RadioGroup)view.findViewById(R.id.answerGroup);
		String[] answers = question.getAnswer();
		
		for (int i = 0; i < answers.length; i++) {
			RadioButton answerButton = new RadioButton(getActivity());
			answerButton.setId(i);
			answerButton.setText(answers[i]);
			answerGroup.addView(answerButton);
		}
	}
}