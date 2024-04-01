package com.bookvault.service;

import com.bookvault.model.BookList;
import com.bookvault.repository.BookListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookListService {

    @Autowired
    private BookListRepository bookListRepo;
    public void saveMyBook(BookList bl){
        bookListRepo.save(bl);
    }
    public List<BookList> getAllMyBooks(){
        return bookListRepo.findAll();
    }

    public void deleteById(int id){
        bookListRepo.deleteById(id);
    }




}
