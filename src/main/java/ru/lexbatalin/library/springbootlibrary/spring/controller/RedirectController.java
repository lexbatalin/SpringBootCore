package ru.lexbatalin.library.springbootlibrary.spring.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.lexbatalin.library.springbootlibrary.domain.Author;
import ru.lexbatalin.library.springbootlibrary.spring.repository.AuthorRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Log
public class RedirectController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request, HttpServletResponse response) {
        List<Author> authorList = authorRepository.findAll();
        System.out.println(authorList);
        return "ok";
    }

}
