package org.example.annotations;

import org.example.algos.Book;
import org.example.structure.Actor;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Test {

    private Book b = new Book("L'étranger");

    public static void main(String[] args) {
        Class<Actor> actor = Actor.class;
        for (Method m : actor.getMethods()) {
            System.out.println(m.getName());
            for (Parameter p : m.getParameters()) {
                System.out.println(p.getName() + ":" + p.getType().getName());
            }
            System.out.println("-------------");
        }
        Class<Book> book = Book.class;
        AnnotatedElement e = (AnnotatedElement) book;
        if (e.isAnnotationPresent(Author.class)) {
            Annotation a = e.getAnnotation(Author.class);
            Author author = (Author) a;
            System.out.println(author.firstName() + ", " + author.lastName());
        }
    }

}
