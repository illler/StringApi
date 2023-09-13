package com.test.stringapi.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StringWrapper {

    @NotNull(message = "String should not be null")
    private String string;

    @Pattern(regexp = "^true$|^false$", message = "allowed input for field 'isLowerCase': true or false")
    private String isLowerCase;

    @Pattern(regexp = "^true$|^false$", message = "allowed input for field 'isContainsSpace': true or false")
    private String isContainsSpace;

}
