package com.sberbank.library.controller;

import com.sberbank.library.constant.View;
import com.sberbank.library.domain.PublishingForm;
import com.sberbank.library.entity.Publishing;
import com.sberbank.library.repository.BookRepository;
import com.sberbank.library.repository.PublishingRepository;
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
public class PublishingController {

    private final PublishingRepository publishingRepository;
    private final BookRepository bookRepository;

    @Autowired
    public PublishingController(PublishingRepository publishingRepository, BookRepository bookRepository) {
        this.publishingRepository = publishingRepository;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/publishings")
    public ModelAndView publishings() {
        ModelAndView modelAndView = new ModelAndView(View.PUBLISHINGS.getPath());
        modelAndView.addObject("publishings", publishingRepository.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/publishing/{id}")
    public ModelAndView publishingPage(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView(View.HOME.getPath());
        modelAndView.addObject("books", bookRepository.findByPublishing_Id(id));
        return modelAndView;
    }

    @RequestMapping(value = "/publishing/add", method = RequestMethod.GET)
    public ModelAndView showPublishingFrom()
    {
        ModelAndView modelAndView = new ModelAndView(View.ADD_PUBLISHING.getPath());
        modelAndView.addObject("publishing", new PublishingForm());
        return modelAndView;
    }

    @RequestMapping(value = "/publishing/add", method = RequestMethod.POST)
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

        return new ModelAndView("redirect:/book/add");
    }
}
