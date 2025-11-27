package com.lasso.lms.infrastructure.controller;

import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lasso.lms.enroll.Dto.EnrollmentDto;
import com.lasso.lms.enroll.infrastructure.controller.EnrollmentControllerImp;
import com.lasso.lms.enroll.service.IEnrollmentService;

@WebMvcTest(EnrollmentControllerImp.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class EnrollmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IEnrollmentService enrollmentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllEnrollments_ShouldReturnOkAndEmptyList() throws Exception {
        // Implement test logic here

        when(enrollmentService.getAllEnrollments()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/v1/enrollments/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isEmpty());

    }

    @Test
    void createEnrollment_ShouldReturnCreatedEnrollmentAndStatus200() throws Exception {
        // Arrange: Prepare test data and define mock behavior
        EnrollmentDto inputDto = new EnrollmentDto(null, null, 1L, "testUser", 10L, "testCourse");
        EnrollmentDto outputDto = new EnrollmentDto(5L, null, 1L, "testUser", 10L, "testCourse");

        // Define what happens when the service's create method is called
        when(enrollmentService.createEnrollment(inputDto)).thenReturn(outputDto);

        // Act & Assert: Perform the POST request
        mockMvc.perform(post("/api/v1/enrollments/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inputDto))) // Send JSON body

                .andExpect(status().isOk()) // Expect HTTP 200 (Spring defaults to 200 for POST unless specified)
                .andExpect(jsonPath("$.id").value(5L)) // Verify the ID was assigned
                .andExpect(jsonPath("$.userId").value(1L)); // Verify the data integrity
    }

}
