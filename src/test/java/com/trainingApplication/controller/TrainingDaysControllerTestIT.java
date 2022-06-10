package com.trainingApplication.controller;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class},
        mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
class TrainingDaysControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DatabaseSetup(value = "classpath:dbunit/create-trainingDay-dataset.xml")
    @ExpectedDatabase(value = "classpath:dbunit/create-trainingDay-expected.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    @DatabaseTearDown(value = "classpath:dbunit/create-trainingDay-teardown.xml", type = DatabaseOperation.DELETE_ALL)
    void shouldCreateTrainingDay() throws Exception {
        mockMvc.perform(post("/training_days")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createTrainingDayJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.createdTrainingDaysId").value("1"));
    }

    @Test
    @DatabaseSetup(value = "classpath:dbunit/find-trainingDay-dataset.xml")
    @DatabaseTearDown(value = "classpath:dbunit/find-trainingDay-dataset.xml")
    void shouldGetTrainingDayById() throws Exception {
        mockMvc.perform(get("/training_days/1000")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createTrainingDayJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.trainingDays.id").value("1000"))
                .andExpect(jsonPath("$.trainingDays.trainingDay").value("test day"))
                .andExpect(jsonPath("$.trainingDays.description").value("test description"));
    }

    private String createTrainingDayJSON() throws JSONException {
        return new JSONObject()
                .put("trainingDay", "test day")
                .put("description", "test description")
                .put("userId", "2000")
                .toString();
    }
}
