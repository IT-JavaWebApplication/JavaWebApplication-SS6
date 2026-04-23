package com.bookstore.controller;

import com.bookstore.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private static List<Book> bookList = new ArrayList<>();

    static {
        bookList.add(new Book(1, "Lập trình Java", "Nguyễn Văn A", 150000));
        bookList.add(new Book(2, "Spring Boot Master", "Trần Thị B", 350000));
        bookList.add(new Book(3, "Microservices Pattern", "Chris Richardson", 500000));
        bookList.add(new Book(4, "Clean Code", "Robert C. Martin", 280000));
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookList);
        return "list";
    }

    @GetMapping("/{id}")
    public String bookDetail(@PathVariable("id") int id, Model model) {
        Book book = bookList.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("book", book);
        return "detail";
    }
}