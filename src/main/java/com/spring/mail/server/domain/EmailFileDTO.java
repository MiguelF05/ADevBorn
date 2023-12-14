package com.spring.mail.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter

public class EmailFileDTO{
    private String[] toUser;
    private String subject;
    private String message;
    private MultipartFile file;

}
