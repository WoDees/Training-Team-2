package com.trainingApplication.domain;

import lombok.Data;

@Data
public class CalendarEntity {

    private Long id;
    private Long userId;
    private String description;
    private String eventDate;
}