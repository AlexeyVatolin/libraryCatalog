package com.sberbank.library.controller;

import com.sberbank.library.constant.View;
import com.sberbank.library.domain.BookForm;
import com.sberbank.library.entity.Book;
import com.sberbank.library.repository.AuthorRepository;
import com.sberbank.library.repository.BookRepository;
import com.sberbank.library.repository.PublishingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublishingRepository publishingRepository;

    @Autowired
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository, PublishingRepository publishingRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publishingRepository = publishingRepository;
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.GET)
    public ModelAndView addBookView() {
        ModelAndView modelAndView = new ModelAndView(View.ADD_BOOK.getPath());
        modelAndView.addObject("authors", authorRepository.findAll());
        modelAndView.addObject("publishings", publishingRepository.findAll());
        modelAndView.addObject("book", new BookForm());
        return modelAndView;
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public ModelAndView addBook(@Valid @ModelAttribute("book") BookForm form, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView(View.ADD_BOOK.getPath());
        if (result.hasErrors()) {
            modelAndView.addObject("result", result);
            modelAndView.addObject("authors", authorRepository.findAll());
            modelAndView.addObject("publishings", publishingRepository.findAll());
            return modelAndView;
        }

        Book book = new Book();
        book.setAuthor(form.getAuthor());
        book.setPublishing(form.getPublishing());
        book.setTitle(form.getTitle());
        book.setNumberOfPage(form.getNumberOfPage());
        book.setPubYear(form.getPubYear());
        book.setNumberOfBooks(form.getNumberOfBooks());
        book.setNumberOfBooksAvailable(form.getNumberOfBooks());
        book.setBookLocation(form.getBookLocation());
        bookRepository.save(book);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/book/search", method = RequestMethod.POST)
    public ModelAndView bookSearch(@RequestParam(value = "searchText", required = false) String searchText) {
        ModelAndView modelAndView = new ModelAndView(View.HOME.getPath());
        List<Book> books = bookRepository.findByTitleContainsIgnoreCase(searchText);
        modelAndView.addObject("books", books);
        modelAndView.addObject("searchCondition", searchText);
        return modelAndView;
    }

    @RequestMapping(value = "/book/{id}")
    public ModelAndView book(@PathVariable("id") Long id) {
        Book book = bookRepository.getOne(id);

        ModelAndView modelAndView = new ModelAndView(View.BOOK.getPath());
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @RequestMapping(value = "/book/{id}/give")
    public ModelAndView giveBook(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView(View.BOOK.getPath());

        Book book = bookRepository.getOne(id);
        if (book.getNumberOfBooksAvailable() > 0) {
            book.giveBook();
            bookRepository.save(book);
        }
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @RequestMapping(value = "/book/{id}/take")
    public ModelAndView takeBook(@PathVariable("id") Long id) {
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
