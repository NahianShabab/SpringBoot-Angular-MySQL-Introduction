package com.vinternship.task3.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@Entity
public class Author {

    @Id
    @GeneratedValue
    private long authorId;
    private String name;

//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "author")
//    List<Book> books;
}
