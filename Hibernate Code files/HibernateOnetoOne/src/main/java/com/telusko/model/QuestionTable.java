package com.telusko.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class QuestionTable
{
	 @Id
	 @Column(name="question_id")
     private Integer id;
	 
     private String question;



    @OneToMany(cascade = CascadeType.ALL)
     private List<AnswerTable>  answerTable;
     
     public QuestionTable()
     {
    	 System.out.println("Zero Param Constructor of Question");
     }

    @Override
    public String toString() {
        return "QuestionTable{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answerTable=" + answerTable +
                '}';
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

    public List<AnswerTable> getAnswerTable() {
        return answerTable;
    }

    public void setAnswerTable(List<AnswerTable> answerTable) {
        this.answerTable = answerTable;
    }


    public void setAnswerList(List<AnswerTable> answers) {
    }
}
