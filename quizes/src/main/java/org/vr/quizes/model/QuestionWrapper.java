package org.vr.quizes.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionWrapper {
        private Long id;
        private String text;
        private String response1;
        private String response2;
        private String response3;
        private String response4;
        private String subject;
}
