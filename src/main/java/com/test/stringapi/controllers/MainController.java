package com.test.stringapi.controllers;

import com.test.stringapi.exceptions.ValidationErrorResponse;
import com.test.stringapi.services.StringWrapperService;
import com.test.stringapi.models.StringWrapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class MainController {

    private final StringWrapperService stringWrapperService;

    @PostMapping("/send-string")
    public ResponseEntity<?> stringHandler(@RequestBody @Valid StringWrapper str, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ValidationErrorResponse errorResponse = new ValidationErrorResponse();
            String fieldErrors =  Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
            errorResponse.setMessage(fieldErrors);
            return ResponseEntity.badRequest().body(errorResponse);
        }
        return new ResponseEntity<>(stringWrapperService.processString(
                str.getString(),
                str.getIsLowerCase(),
                str.getIsContainsSpace()
        ), HttpStatus.OK);
    }


}
