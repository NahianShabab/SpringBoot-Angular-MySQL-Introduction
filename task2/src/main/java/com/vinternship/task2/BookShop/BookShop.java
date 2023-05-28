package com.vinternship.task2.BookShop;

import com.vinternship.task2.Book.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="BookShop")
public class BookShop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long number;
    private String name;
    private String location;
    private String contact;
    private String email;

    @ManyToMany
    @JoinTable(name="BookShop_Book",
    joinColumns = @JoinColumn(name = "number"),
    inverseJoinColumns = @JoinColumn(name="id")
    )
    private Set<Book> books=new HashSet<Book>();
}
