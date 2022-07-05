package ru.dorofeev.sberbankproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.dorofeev.sberbankproject.model.dto.ViewedDto;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/sql/insert-data-for-viewed.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/sql/delete-data-for-viewed.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class TestViewedController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ViewedController viewedController;

    @Test
    public void checkControllerIsNotNull_ReturnNotNull() {
        Assertions.assertNotNull(viewedController);
    }

    @Test
    public void save_SaveUserViewedContents() throws Exception {

        ViewedDto viewedDto = ViewedDto.builder()
                .userGuid(UUID.fromString("10000000-0000-0000-0000-000000000000"))
                .contentGuid(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/viewed/save")
                        .content(objectMapper.writeValueAsString(List.of(viewedDto)))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getInfoAboutAllViews_ReturnInformationAboutAllViewedByUsersContents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/viewed/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].userGuid").value("00000000-0000-0000-0000-000000000000"))
                .andExpect(jsonPath("$[0].contentGuid").value("00000000-0000-0000-0000-000000000000"))
                .andExpect(jsonPath("$[1].userGuid").value("10000000-0000-0000-0000-000000000000"))
                .andExpect(jsonPath("$[1].contentGuid").value("10000000-0000-0000-0000-000000000000"))
                .andExpect(jsonPath("$[2].userGuid").value("20000000-0000-0000-0000-000000000000"))
                .andExpect(jsonPath("$[2].contentGuid").value("20000000-0000-0000-0000-000000000000"));
    }

    @Test
    public void getInfoByIdUserAboutViews_ReturnInformationAboutContentViewedByUser() throws Exception {

        UUID uuid = UUID.fromString("00000000-0000-0000-0000-000000000000");

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/viewed/{id}", uuid))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].userGuid").value("00000000-0000-0000-0000-000000000000"))
                .andExpect(jsonPath("$[0].contentGuid").value("00000000-0000-0000-0000-000000000000"));
    }
}