package org.vr.quizes;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.vr.quizes.feign.QuizInterface;
import org.vr.quizes.model.QuestionResponse;
import org.vr.quizes.model.QuestionWrapper;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class QuizesApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizesApplication.class, args);
    }

}
