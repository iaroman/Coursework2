package com.example.coursework2;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
@Service
public class ExaminerServiceImpl implements ExaminerService{

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size())
            throw new NumberIsExceededException("The number of questions requested is greater than the number of available ones");
        List<Question> list = new LinkedList<>();
        for (int i = 1; i <= amount; i++) {
            list.add(questionService.getRandomQuestion());
        }
        return list;
    }
}
