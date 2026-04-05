package com.telusko.model;

import jakarta.persistence.*;

@Entity
public class AnswerTable {

    @Id
    @Column(name="answer_id")
    private Integer id;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "question_id")   // FK column
    private QuestionTable question;

    public AnswerTable() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }

    public QuestionTable getQuestion() { return question; }
    public void setQuestion(QuestionTable question) { this.question = question; }
}













