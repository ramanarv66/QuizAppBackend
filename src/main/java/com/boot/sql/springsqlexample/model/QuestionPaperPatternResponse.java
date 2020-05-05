package com.boot.sql.springsqlexample.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionPaperPatternResponse {
    private List<StringBuffer> question = new ArrayList<StringBuffer>();
    private OptionsResponse options;

}
