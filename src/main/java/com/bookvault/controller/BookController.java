package com.bookvault.controller;


import com.bookvault.model.Book;
import com.bookvault.model.BookList;
import com.bookvault.service.BookListService;
import com.bookvault.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService service;

    @Autowired
    private BookListService myBookService;
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/book_register")
    public  String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBooks(){
        List<Book> list = service.getAllBook();
        return new ModelAndView("bookList","book",list );
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book b){
        service.save(b);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<BookList> list = myBookService.getAllMyBooks();
        model.addAttribute("book", list);
        return "myBooks";
    }

    @RequestMapping("/myBookList/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b = service.getBookById(id);
        BookList bl = new BookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookService.saveMyBook(bl);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable int id, Model model){
        Book b=service.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
        service.deleteById(id);
        return "redirect:/available_books";
    }


}
