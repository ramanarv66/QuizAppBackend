package com.boot.sql.springsqlexample;

import com.boot.sql.springsqlexample.model.QuestionPaperPatternResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@Slf4j
public class SpringsqlexampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringsqlexampleApplication.class, args);


    }

    private String readFromInputStream(InputStream inputStream, QuestionPaperPatternResponse questionPaperPatternResponse)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();


        List<StringBuffer> question = new ArrayList<StringBuffer>();
        List<StringBuffer> options = new ArrayList<StringBuffer>();
        List<StringBuffer> bigQuestion = new ArrayList<StringBuffer>();
        List<String> answer = new ArrayList<String>();
        List<String> bigQuestionOptions = new ArrayList<String>();
        List<String> bigQuestionAnswers = new ArrayList<String>();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            boolean addBigOptions = false;
            StringBuffer temp = new StringBuffer();
            while ((line = br.readLine()) != null) {
                final boolean b = line.contains("a)") || line.contains("b)") || line.contains("c)") || line.contains("d)") || line.contains("e)");

                if (Objects.nonNull(line) && !line.isEmpty() && line.length() > 0) {
                    if (addBigOptions && b) {
                        bigQuestionOptions.add(line);
                        continue;
                    } else if (addBigOptions && line.contains("A)")) {
                        bigQuestionAnswers.add(line);
                        addBigOptions = false;
                        continue;
                    }
                    if (line.contains(")") && line.contains("?")) {
                        question.add(new StringBuffer(line));
                        temp = question.get(question.size() - 1);
                    } else {
                        if (b) {
                            options.add(new StringBuffer(line));
                        } else if (line.contains("A)")) {
                            answer.add(line);
                        } else {
                            if (!line.contains("a)") || !line.contains("b)") || !line.contains("c)") || !line.contains("d)") || !line.contains("e)")) {
                                if (b) {
                                    options.add(new StringBuffer(line));
                                } else {
                                    if (!bigQuestion.contains(temp)) {
                                        bigQuestion.add(temp);
                                        bigQuestion.add(new StringBuffer(line));
                                        question.remove(question.size() - 1);
                                        // need last 4 options
                                        /*for (int i =answer.size()-1 ; i > ; i--) {

                                        }*/

                                    } else {
                                        // if
                                        if (bigQuestionOptions.size() > 0) {
                                            if (bigQuestionOptions.get(bigQuestionOptions.size() - 1).contains("a)") ||
                                                    bigQuestionOptions.get(bigQuestionOptions.size() - 1).contains("b)") ||
                                                    bigQuestionOptions.get(bigQuestionOptions.size() - 1).contains("c)") ||
                                                    bigQuestionOptions.get(bigQuestionOptions.size() - 1).contains("d)") &&
                                                            !line.contains(")") && !line.contains("}") && !line.contains("{")) {
                                                bigQuestionOptions.add(line);

                                            } else if (!bigQuestionOptions.get(bigQuestionOptions.size() - 1).contains(")")) {
                                                bigQuestionOptions.add(line);
                                            } else {
                                                bigQuestion.add(new StringBuffer(line));
                                                addBigOptions = true;
                                            }


                                        } else {
                                            bigQuestion.add(new StringBuffer(line));
                                            addBigOptions = true;
                                        }

                                        /*if (bigQuestionOptions.size() > 0 &&
                                                bigQuestionOptions.get(bigQuestionOptions.size() - 1)
                                                        .contains("a)") && !b
                                                ) {
                                            bigQuestionOptions.add(line);

                                        } else {
                                            *//*if(bigQuestionOptions.size() > 0 && !bigQuestionOptions.get(bigQuestionOptions.size()-1).contains("a)") &&
                                                    !bigQuestionOptions.get(bigQuestionOptions.size()-1).contains("b)") &&
                                                    !bigQuestionOptions.get(bigQuestionOptions.size()-1).contains("c)") &&
                                                    !bigQuestionOptions.get(bigQuestionOptions.size()-1).contains("d)") &&
                                                    !bigQuestionOptions.get(bigQuestionOptions.size()-1).contains("e)")  ){
                                                bigQuestionOptions.add(line);
                                                continue;

                                            }else{
                                                bigQuestion.add(new StringBuffer(line));
                                                addBigOptions = true;
                                            }*//*
                                            bigQuestion.add(new StringBuffer(line));
                                            addBigOptions = true;
                                        }*/


                                    }
                                }
                            }
                        }
                    }
                }
                resultStringBuilder.append(line).append("\n");
            }
        }
        System.out.println(question);
        System.out.println(options);
        System.out.println(answer);
        System.out.println("*********");
        System.out.println(bigQuestion);
        System.out.println(bigQuestionOptions);
        System.out.println(bigQuestionAnswers);
        question.stream().forEach(a -> log.info(a.toString()));
        options.stream().forEach(a -> log.info(a.toString()));
        answer.stream().forEach(a -> log.info(a.toString()));
        log.info("*********");
        bigQuestion.stream().forEach(a -> log.info(a.toString()));
        bigQuestionOptions.stream().forEach(a -> log.info(a.toString()));
        bigQuestionAnswers.stream().forEach(a -> log.info(a.toString()));
       /* question.stream().forEach(a->log.info(a.toString()));
        log.info(question.toString());
        log.info(options.toString());
        log.info(answer.toString());
        log.info("*********");
        log.info(bigQuestion.toString());
        log.info(bigQuestionOptions.toString());
        log.info(bigQuestionAnswers.toString());*/
        return resultStringBuilder.toString();
    }

    @Override
    public void run(String... args) throws Exception {
        final String CONFIG_FILE = "question_paper_pattern1.txt";
        QuestionPaperPatternResponse questionPaperPatternResponse = new QuestionPaperPatternResponse();
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(CONFIG_FILE);
        String data = readFromInputStream(inputStream, questionPaperPatternResponse);
        //  log.info(data);
    }
}
