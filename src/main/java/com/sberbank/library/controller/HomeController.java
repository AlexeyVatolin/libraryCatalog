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
    private final AuthorRepository authorRepository;
    private final PublishingRepository publishingRepository;

    @Autowired
    public HomeController(BookRepository bookRepository, AuthorRepository authorRepository,
                          PublishingRepository publishingRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publishingRepository = publishingRepository;
    }

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(View.HOME.getPath());
        modelAndView.addObject("books", bookRepository.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public ModelAndView addBookView() {
        ModelAndView modelAndView = new ModelAndView(View.ADD_BOOK.getPath());
        modelAndView.addObject("authors", authorRepository.findAll());
        modelAndView.addObject("publishings", publishingRepository.findAll());
        modelAndView.addObject("book", new BookForm());
        return modelAndView;
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
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
        bookRepository.saveAndFlush(book);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/addAuthor", method = RequestMethod.GET)
    public ModelAndView showAuthorFrom()
    {
        ModelAndView modelAndView = new ModelAndView(View.ADD_AUTHOR.getPath());
        modelAndView.addObject("author", new AuthorForm());
        return modelAndView;
    }

    @RequestMapping(value = "/addAuthor", method = RequestMethod.POST)
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

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/addPublishing", method = RequestMethod.GET)
    public ModelAndView showPublishingFrom()
    {
        ModelAndView modelAndView = new ModelAndView(View.ADD_PUBLISHING.getPath());
        modelAndView.addObject("publishing", new PublishingForm());
        return modelAndView;
    }

    @RequestMapping(value = "/addPublishing", method = RequestMethod.POST)
    public ModelAndView addPublishing(@Valid @ModelAttribute("Publishing") PublishingForm form,
                                      BindingResult result)
    {
        if(result.hasErrors())
        {
            ModelAndView modelAndView = new ModelAndView(View.ADD_PUBLISHING.getPath());
            modelAndView.addObject("result", result);
            return modelAndView;
        }
        Publishing publishing = new Publishing();
        publishing.setName(form.getName());
        publishingRepository.saveAndFlush(publishing);

        return new ModelAndView("redirect:/");
    }


    @RequestMapping(value = "/searchBook", method = RequestMethod.POST)
    public ModelAndView bookSearch(@RequestParam(value = "searchText", required = false) String searchText,
                                   HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(View.HOME.getPath());
        List<Book> books = bookRepository.findByTitleContainsIgnoreCase(searchText);
        modelAndView.addObject("books", books);
        modelAndView.addObject("searchCondition", searchText);
        return modelAndView;
    }
}
