package com.example.coursework2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    JavaQuestionService javaQuestionService = new JavaQuestionService();
    void setUpAdd() {
        javaQuestionService.add("who", "you");
        javaQuestionService.add("why", "i dont now");
        javaQuestionService.add("where", "tut");
        javaQuestionService.add("how", "kak to tak");
        javaQuestionService.add("i..", "bez i ..");
    }
    @ParameterizedTest
    @CsvSource({
            "who, you",
            "why, i dont now",
            "where, tut",
            "how, kak to tak",
            "i.., bez i .."
    })
    void add(String question, String answer) {
        Question actual = new Question(question, answer);
        Question expected = javaQuestionService.add(question, answer);
        assertEquals(expected, actual);
    }
    public static Stream<Arguments> provideParamsForTestAdd() {
        return Stream.of(
                Arguments.of(new Question("who", "you")),
                Arguments.of(new Question("why", "i dont now")),
                Arguments.of(new Question("where", "tut")),
                Arguments.of(new Question("how", "kak to tak")),
                Arguments.of(new Question("i..", "bez i .."))
        );
    }
    @ParameterizedTest
    @MethodSource("provideParamsForTestAdd")
    void testAdd(Question actual) {
        Question expected = javaQuestionService.add(actual);
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTestAdd")
    void remove(Question question) {
        javaQuestionService.add(question);
        assertTrue(javaQuestionService.getAll().contains(question));
        Question expected = javaQuestionService.remove(question);
        assertEquals(question, expected);
        assertFalse(javaQuestionService.getAll().contains(question));
    }

    @Test
    void getAll() {
        assertTrue(javaQuestionService.getAll().size() == 0);
        setUpAdd();
        assertTrue(javaQuestionService.getAll().size() == 5);
    }

    @Test
    void getRandomQuestion() {
        setUpAdd();
        Question expected = javaQuestionService.getRandomQuestion();
        assertTrue(javaQuestionService.getAll().contains(expected));
    }
}