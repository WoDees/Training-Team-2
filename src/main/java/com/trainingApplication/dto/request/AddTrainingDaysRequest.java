package com.trainingApplication.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class AddTrainingDaysRequest {

    @NotBlank
    @NotNull
    @Length(min = 1, max = 20)
    private String trainingDay;
    @NotBlank
    @NotNull
    @Length(min = 5, max = 50)
    private String description;
    @NotNull
    @Range(min = 1)
    private Long userId;
}
