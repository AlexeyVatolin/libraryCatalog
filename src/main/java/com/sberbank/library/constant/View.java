package com.sberbank.library.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public enum View {
    HOME("index"),
    ADD_BOOK("addBook"),
    ADD_AUTHOR("addAuthor"),
    ADD_PUBLISHING("addPublishing");

    private final String path;

/*    public String getRedirect(){
        return "redirect:/" + path;
    }*/
}