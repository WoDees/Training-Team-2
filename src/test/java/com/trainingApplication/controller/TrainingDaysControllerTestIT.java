package com.trainingApplication.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class TrainingDaysControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateTrainingDay() throws Exception {
        mockMvc.perform(post("/training_days")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createTrainingDayJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.createdTrainingDaysId").value("1"));
    }

    private String createTrainingDayJSON() throws JSONException {
        return new JSONObject()
                .put("trainingDate", "04/01/2000")
                .put("description", "qwerty123")
                .put("userId", 1)
                .toString();
    }
}
