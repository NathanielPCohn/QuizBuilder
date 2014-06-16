package com.example.quizbuilder;

import java.util.ArrayList;
import java.util.UUID;

public class Quiz {
	private static Quiz quiz;
	private ArrayList<Question> questionSet;
	
	private Quiz() {
		questionSet = new ArrayList<Question>();
		String[] answers = {"Wine","Beer","Whiskey","None"};
		questionSet.add(new Question(
				"Which of the following has nutritional value?",
				answers,
				4));
	}
	
	public static Quiz getInstance() {
		if(quiz == null) {
			quiz = new Quiz();
		}
		return quiz;
	}
	
	public ArrayList<Question> getQuestionSet() {
		return questionSet;
	}
	
	public Question getQuestion(UUID id) {
		for (Question item: questionSet) {
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}
}