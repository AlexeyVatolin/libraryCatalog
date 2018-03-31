package com.sberbank.library.controller;

import com.sberbank.library.constant.View;
import com.sberbank.library.domain.BookForm;
import com.sberbank.library.domain.AuthorForm;
import com.sberbank.library.domain.PublishingForm;
import com.sberbank.library.entity.Author;
import com.sberbank.library.entity.Book;
import com.sberbank.library.entity.Publishing;
import com.sberbank.library.repository.AuthorRepository;
import com.sberbank.library.repository.BookRepository;
import com.sberbank.library.repository.PublishingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    private final BookRepository bookRepository;

    @Autowired
    public HomeController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(View.HOME.getPath());
        modelAndView.addObject("books", bookRepository.findAll());
        return modelAndView;
    }
}
