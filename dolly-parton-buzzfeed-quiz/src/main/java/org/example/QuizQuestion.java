package org.example;

import java.util.ArrayList;
import java.util.List;

public class QuizQuestion {
    private List<String> answers = new ArrayList<>();
    private String question = "";

    int red = 0;
    int blue = 0;
    int green = 0;
    int yellow = 0;
    String blend = "Blend";

    public List<String> getAnswers() {
        return answers;
    }

    public String getQuestion() {
        return question;
    }

    public String getRedGroupAnswer() {
        return String.valueOf(red);
    }

    public String getBlueGroupAnswer() {
        return String.valueOf(blue);
    }

    public String getGreenGroupAnswer() {
        return String.valueOf(green);
    }

    public String getYellowGroupAnswer() {
        return String.valueOf(yellow);
    }

    public QuizQuestion(String[] questionAndAnswer) {
        question = questionAndAnswer[0];

        for (int i = 0; i < questionAndAnswer.length; i++) {
            if (questionAndAnswer[i].contains("*")) {
                answers.add(questionAndAnswer[i].substring(0, questionAndAnswer[i].length() - 1));
                red = i;
            }
            if (questionAndAnswer[i].contains("^")) {
                answers.add(questionAndAnswer[i].substring(0, questionAndAnswer[i].length() - 1));
                blue = i;
            }
            if (questionAndAnswer[i].contains("$")) {
                answers.add(questionAndAnswer[i].substring(0, questionAndAnswer[i].length() - 1));
                green = i;
            }
            if (questionAndAnswer[i].contains("#")) {
                answers.add(questionAndAnswer[i].substring(0, questionAndAnswer[i].length() - 1));
                yellow = i;
            }
        }
    }
}