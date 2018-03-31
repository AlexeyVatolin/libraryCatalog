package com.sberbank.library.controller;

import com.sberbank.library.constant.View;
import com.sberbank.library.domain.AuthorForm;
import com.sberbank.library.entity.Book;
import com.sberbank.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/{id}")
    public ModelAndView book(@PathVariable("id") Long id)
    {
        Book book = bookRepository.getOne(id);

        ModelAndView modelAndView = new ModelAndView(View.BOOK.getPath());
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/give")
    public ModelAndView giveBook(@PathVariable("id") Long id)
    {
        ModelAndView modelAndView = new ModelAndView(View.BOOK.getPath());

        Book book = bookRepository.getOne(id);
        if (book.getNumberOfBooksAvailable() > 0) {
            book.giveBook();
            bookRepository.save(book);
        }
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/take")
    public ModelAndView takeBook(@PathVariable("id") Long id)
    {
        ModelAndView modelAndView = new ModelAndView(View.BOOK.getPath());

        Book book = bookRepository.getOne(id);
        if (book.getNumberOfBooksAvailable() < book.getNumberOfBooks()) {
            book.takeBook();
            bookRepository.save(book);
        }
        modelAndView.addObject("book", book);
        return modelAndView;
    }


}
