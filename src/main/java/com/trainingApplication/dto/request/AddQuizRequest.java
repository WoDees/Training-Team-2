package com.trainingApplication.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class AddQuizRequest {

    @NotNull
    @Range(min = 1)
    private Long gender;
    @NotNull
    @Length(min = 1, max = 99)
    private Long age;
    @NotNull
    @Length(min = 1, max = 300)
    private Long weight;
    @NotNull
    @Length(min = 100, max = 250)
    private Long growth;
    @NotNull
    @Length(min = 1, max = 300)
    private Long desiredWeight;
    @NotBlank
    @NotNull
    @Length(min = 1, max = 255)
    private String target;
    @NotNull
    @Range(min = 1)
    private Long userId;
}
