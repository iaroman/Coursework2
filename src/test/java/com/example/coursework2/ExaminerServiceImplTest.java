package com.example.coursework2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    Set<Question> questionsTest;
    @Mock
    QuestionService questionServiceMock;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        questionsTest = new HashSet<>();
        questionsTest.add(new Question("who", "you"));
        questionsTest.add(new Question("why", "i dont now"));
        questionsTest.add(new Question("where", "tut"));
        questionsTest.add(new Question("how", "kak to tak"));
        questionsTest.add(new Question("i..", "bez i .."));
    }
    @ParameterizedTest
    @CsvSource({
            "1",
            "3",
            "5"
    })
    void getQuestionsTestAmount(int amount) {
        when(questionServiceMock.getAll()).thenReturn(questionsTest);
        when(questionServiceMock.getRandomQuestion()).thenReturn(
                new Question("some question", "some answer"));
        int expected = examinerService.getQuestions(amount).size();
        assertEquals(amount, expected);
    }
    @ParameterizedTest
    @CsvSource({
            "11",
            "50",
            "100"
    })
    void getQuestionsTestException(int amount) {
        when(questionServiceMock.getAll()).thenReturn(questionsTest);
        assertThrows(NumberIsExceededException.class,
                () -> examinerService.getQuestions(amount));
    }
}