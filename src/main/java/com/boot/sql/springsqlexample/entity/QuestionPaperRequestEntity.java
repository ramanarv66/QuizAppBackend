package com.boot.sql.springsqlexample.entity;

import com.boot.sql.springsqlexample.model.QuestionOptionsRequest;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name="QUESTION_PAPER")
public class QuestionPaperRequestEntity implements Serializable {
    @Id
    @GeneratedValue
    int id;
    QuestionOptionsRequest questionOptions[];
}
