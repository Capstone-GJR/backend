package com.capstone.backend.web;

import com.capstone.backend.services.MailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;



@AllArgsConstructor
@RestController
@RequestMapping(value = "/mail")
public class MailController {

    MailService mailService;

    @PostMapping("/send-text")
    public String send() throws IOException {
        return mailService.sendTextEmail();
    }


}