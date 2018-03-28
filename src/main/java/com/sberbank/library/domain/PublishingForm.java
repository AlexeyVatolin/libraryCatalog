package com.sberbank.library.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class PublishingForm {
    @Size(min = 1)
    private String name;
}
