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

    @NotBlank
    @NotNull
    @Range(min = 1)
    private Long gender;
    @NotBlank
    @NotNull
    @Length(min = 1, max = 99)
    private Long age;
    @NotBlank
    @NotNull
    @Length(min = 1, max = 300)
    private Long weight;
    @NotBlank
    @NotNull
    @Length(min = 100, max = 250)
    private Long growth;
    @NotBlank
    @NotNull
    @Length(min = 1, max = 300)
    private Long desiredWeight;
    @NotBlank
    @NotNull
    @Length(min = 1, max = 255)
    private String target;
    @NotBlank
    @NotNull
    @Range(min = 1)
    private Long userId;
}
