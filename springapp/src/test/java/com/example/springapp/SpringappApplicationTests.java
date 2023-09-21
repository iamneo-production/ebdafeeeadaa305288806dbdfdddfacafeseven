package com.example.springapp;




import com.example.springapp.controller.TemperatureController;

import com.example.springapp.service.TemperatureService;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;




import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;




import java.io.File;




@WebMvcTest(TemperatureController.class)

public class SpringappApplicationTests {




    @Autowired

    private MockMvc mockMvc;




    @MockBean

    private TemperatureService temperatureService;




    @Test

    public void testConvertToCelsius() throws Exception {

        double temperatureCelsius = 25.0;

        double expectedTemperatureFahrenheit = 77.0;




        // Mock behavior of the TemperatureService

        Mockito.when(temperatureService.convertToCelsius(temperatureCelsius))

               .thenReturn(expectedTemperatureFahrenheit);




        // Test the /convert endpoint

        mockMvc.perform(post("/convert").contentType("application/json").content("25.0"))

               .andExpect(status().isOk())

               .andExpect(content().string("77.0"));

    }

    @Test

    public void testcontrollerfolder() {

        String directoryPath = "src/main/java/com/example/springapp/controller"; // Replace with the path to your directory

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

   

    @Test

    public void testcontrollerfile() {

        String filePath = "src/main/java/com/example/springapp/controller/TemperatureController.java";

        // Replace with the path to your file

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }

    @Test

    public void testServiceFolder() {

        String directoryPath = "src/main/java/com/example/springapp/service"; // Replace with the path to your directory

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

   

    @Test

    public void testServieFile() {

        String filePath = "src/main/java/com/example/springapp/service/TemperatureService.java";

        // Replace with the path to your file

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }

}