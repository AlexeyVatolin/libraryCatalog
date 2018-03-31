package com.sberbank.library.controller;

import com.sberbank.library.constant.View;
import com.sberbank.library.domain.AuthorForm;
import com.sberbank.library.entity.Author;
import com.sberbank.library.repository.AuthorRepository;
import com.sberbank.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/authors")
    public ModelAndView authors() {
        ModelAndView modelAndView = new ModelAndView(View.AUTHORS.getPath());
        modelAndView.addObject("authors", authorRepository.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/author/{id}")
    public ModelAndView authorPage(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView(View.HOME.getPath());
        modelAndView.addObject("books", bookRepository.findByAuthor_Id(id));
        return modelAndView;
    }

    @RequestMapping(value = "/author/add", method = RequestMethod.GET)
    public ModelAndView showAuthorFrom()
    {
        ModelAndView modelAndView = new ModelAndView(View.ADD_AUTHOR.getPath());
        modelAndView.addObject("author", new AuthorForm());
        return modelAndView;
    }

    @RequestMapping(value = "/author/add", method = RequestMethod.POST)
    public ModelAndView addAuthor(@Valid @ModelAttribute("author") AuthorForm form, BindingResult result)
    {
        if(result.hasErrors())
        {
            ModelAndView modelAndView = new ModelAndView(View.ADD_AUTHOR.getPath());
            modelAndView.addObject("result", result);
            return modelAndView;
        }
        Author author = new Author();
        author.setFirstName(form.getFirstName());
        author.setLastName(form.getLastName());
        author.setPatronymic(form.getPatronymic());
        authorRepository.saveAndFlush(author);

        return new ModelAndView("redirect:/book/add");
    }
}
