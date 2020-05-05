package com.boot.sql.springsqlexample.config;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Test {
    public static void main(String[] args) {
        List<StringBuffer> question = new ArrayList<StringBuffer>();
        question.add(new StringBuffer("Test1"));
        question.add(new StringBuffer("Test2"));
        question.add(new StringBuffer("Test3"));
        question.stream().forEach(a -> log.info(a.toString()));
    }
}
