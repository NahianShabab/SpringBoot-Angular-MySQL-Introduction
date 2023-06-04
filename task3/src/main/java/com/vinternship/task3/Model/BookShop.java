package com.vinternship.task3.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BookShop {
    @Id
    @GeneratedValue
    private long bookShopId;
    @Column(nullable = false,unique = true)
    private String title;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String contactNo;
    @Column(nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BookShop_Books",
    joinColumns = @JoinColumn(name="bookShopId",nullable = false,referencedColumnName = "bookShopId"),
    inverseJoinColumns = @JoinColumn(name="bookId",nullable = false,referencedColumnName = "bookId")
    )
    private Set<Book> books;
}
