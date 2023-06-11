package com.vinternship.task3.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue
    private long bookId;
    @Column(nullable = false,unique = true)
    private String title;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = false)
    private String publisher;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(nullable = false,name = "author_id")
//    Author author;
}
