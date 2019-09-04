package br.com.senior.boy.model;

import javax.persistence.Entity;

/**
 * Object model Greeting
 * @author joel
 *
 */
@Entity
public class Greeting extends TransactionalEntity {

    private static final long serialVersionUID = 1L;

    private String text;

    public Greeting() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
