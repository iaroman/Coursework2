package com.example.coursework2;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
  /*  public static void main(String[] args) {
        JavaQuestionService javaQuestionService = new JavaQuestionService();
        javaQuestionService.add("who", "you");
        javaQuestionService.add("why", "i dont now");
        javaQuestionService.add("where", "tut");
        javaQuestionService.add("how", "kak to tak");
        javaQuestionService.add("i..", "bez i ..");
        System.out.println(javaQuestionService.getAll());

        System.out.println(javaQuestionService.remove(new Question("i..", "bez i ..")));
        System.out.println(javaQuestionService.remove(new Question("who", "you")));
        System.out.println(javaQuestionService.remove(new Question("why", "i dont now")));
        System.out.println(javaQuestionService.getAll());
    }*/
    private Set<Question> questions = new HashSet<>();

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
