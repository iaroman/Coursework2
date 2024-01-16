package com.example.coursework2;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }
    @GetMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }
    @PostConstruct
    public void test() {
        questionService.add("who", "you");
        questionService.add("why", "i dont now");
        questionService.add("where", "tut");
        questionService.add("how", "kak to tak");
        questionService.add("i..", "bez i ..");
    }
}
