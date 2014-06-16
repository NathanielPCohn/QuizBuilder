package com.example.quizbuilder;

import java.util.UUID;

public class Question {
	private UUID id;
	private String question;
	private String[] answer;
	private int correctAnswer;
	private int questionPic;
	
	public Question(String q, String[] a, int ca) {
		id = UUID.randomUUID();
		question = q;
		answer = a;
		correctAnswer = ca;
	}
	
	public UUID getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getAnswer() {
		return answer;
	}

	public void setAnswer(String[] answer) {
		this.answer = answer;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public int getQuestionPic() {
		return questionPic;
	}

	public void setQuestionPic(int questionPic) {
		this.questionPic = questionPic;
	}
}