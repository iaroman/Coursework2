package com.example.coursework2;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions = new HashSet<>();
//    private int randomQuestion = new Random().nextInt(questions.size());
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }
    public Question add(Question question) {
        questions.add(question);
        return question;
    }
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }
    public Collection<Question> getAll() {
        return questions;
    }
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(this.getAll());
        return list.get(new Random().nextInt(questions.size()));
    }
}
