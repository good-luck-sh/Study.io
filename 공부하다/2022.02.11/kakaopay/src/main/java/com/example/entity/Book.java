package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;
    @Column(name = "book_title")
    private String title;
    @Column(name = "book_author")
    private String author;
    @Column(name = "book_publisher")
    private String publisher;
    @Column(name = "book_price")
    private int price;
    @Column(name = "book_discount_price")
    private int discountPrice;
    @Column(name = "book_stock")
    private int stock;

    public Book(String title, String author, String publisher, int price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.discountPrice = (int) Math.round(price*0.9);
    }
}
