package org.example;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizMaker {


    public static void main (String[] args) {

        System.out.println("Welcome to the Quiz!");
        System.out.println("Where too many questions is the point");
        System.out.println("Here you will be tested on your love of");
        System.out.println("Dolly Parton!");
        System.out.println("Answer honestly, there are no wrong answers.");
        System.out.println("Your fandom will be ranked accordingly at the end of the quiz");

        List<QuizQuestion> listOfQuestions = new ArrayList<>();
        List<String> answers = new ArrayList<>();

        Scanner userInput = new Scanner(System.in);
        File file = new File("Dolly-Parton-Quiz.txt");

        try (Scanner fileInput = new Scanner(file, StandardCharsets.UTF_8.name())) {

            int red = 0;
            int blue = 0;
            int green = 0;
            int yellow = 0;
            String blend = "Blend";


            while (fileInput.hasNextLine()) {

                String line = fileInput.nextLine();
                String[] questionSplit = line.split("\\|");
                QuizQuestion quizQuestion = new QuizQuestion(questionSplit);
                listOfQuestions.add(quizQuestion);

            }

            for (QuizQuestion question : listOfQuestions) {
                if (question.getQuestion() == "") {
                    System.out.println("I'm making a tally...!");
                    System.out.println(findMostChosen(red, blue, green, yellow) + " This is the most fitting category for all of your the answers out of a total " + listOfQuestions.size() + " questions asked.");
                    break;
                }

                System.out.println(question.getQuestion());
                answers = question.getAnswers();
                System.out.println("1. " + answers.get(0));
                System.out.println("2. " + answers.get(1));
                System.out.println("3. " + answers.get(2));
                System.out.println("4. " + answers.get(3));
                System.out.println("5. " + answers.get(4));
                System.out.println("6. " + answers.get(5));
                System.out.println("Your Answer: ");
                String userAnswer = userInput.nextLine();
                int intAnswer = Integer.parseInt(userAnswer);
                if (userAnswer.equals(question.getRedGroupAnswer())) {

                    red++;
                }
                if (userAnswer.equals(question.getBlueGroupAnswer())) {

                    blue++;
                }
                if (userAnswer.equals(question.getGreenGroupAnswer())) {
                    green++;
                }
                if (userAnswer.equals(question.getYellowGroupAnswer())) {
                    yellow++;
                }
                else if (intAnswer >= 7){
                    System.out.println("Sorry, I don't understand you. Next question...!");
                }

            }
            System.out.println("Hmmmmm... let's see here. Okay-- results are ready!");
            System.out.println(findMostChosen(red, blue, green, yellow) + " This is the most fitting category for all of your the answers out of a total " + listOfQuestions.size() + " questions asked.");


        } catch (IOException e) {
            System.out.println("Could not open file");
        }
    }

    public static String findMostChosen(int red, int blue, int green, int yellow) {
        String redChoice = "You are a super fan! You appreciate life more because of Dolly.";
        String blueChoice = "You are a true fan. Do you go to Dollywood on opening day? Nah";
        String greenChoice = "You've heard of Dolly Parton, and probably love Jolene.";
        String yellowChoice = "You clearly haven't heard of Dolly Parton...";
        if (red >= blue && red >= green && red >= yellow) {
            return redChoice;
        }
        if (green >= red && green >= blue && green >= yellow) {
            return greenChoice;
        }
        if (blue >= red && blue >= green && blue >= yellow) {
            return blueChoice;
        }
        if (yellow >= red && yellow >= blue && yellow >= green) {
            return yellowChoice;
        } else {
            return "You are sending me mixed signals. Try taking the quiz again!";
        }
    }

}

