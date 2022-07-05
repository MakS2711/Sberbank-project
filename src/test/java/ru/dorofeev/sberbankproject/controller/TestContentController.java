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
import ru.dorofeev.sberbankproject.model.dto.ContentDto;
import ru.dorofeev.sberbankproject.model.dto.PageDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/sql/insert-data-for-content.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/sql/delete-data-for-content.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class TestContentController {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ContentController contentController;

    @Test
    public void checkControllerIsNotNull_ReturnNotNull() {
        Assertions.assertNotNull(contentController);
    }

    @Test
    void save_SaveContents() throws Exception {

        ContentDto contentDto = ContentDto.builder()
                .contentGuid(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                .pages(Set.of(
                                PageDto.builder()
                                        .pageName("PAGE_HOME")
                                        .build(),

                                PageDto.builder()
                                        .pageName("PAGE_HOME1")
                                        .build(),

                                PageDto.builder()
                                        .pageName("PAGE_HOME2")
                                        .build()
                        )
                )
                .build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/content/save")
                        .content(objectMapper.writeValueAsString(List.of(contentDto)))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getAll_ReturnAllContent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/content/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].contentGuid").value("00000000-0000-0000-0000-000000000000"))
                .andExpect(jsonPath("$[0].pages.[0].pageName").value("PAGE_HOME1"))
                .andExpect(jsonPath("$[0].pages.[1].pageName").value("PAGE_HOME2"))
                .andExpect(jsonPath("$[0].pages.[2].pageName").value("PAGE_HOME"))
                .andExpect(jsonPath("$[1].contentGuid").value("10000000-0000-0000-0000-000000000000"))
                .andExpect(jsonPath("$[1].pages.[0].pageName").value("PAGE_HOME1"))
                .andExpect(jsonPath("$[1].pages.[1].pageName").value("PAGE_HOME2"))
                .andExpect(jsonPath("$[1].pages.[2].pageName").value("PAGE_HOME"))
                .andExpect(jsonPath("$[2].contentGuid").value("20000000-0000-0000-0000-000000000000"))
                .andExpect(jsonPath("$[2].pages.[0].pageName").value("PAGE_HOME1"))
                .andExpect(jsonPath("$[2].pages.[1].pageName").value("PAGE_HOME2"))
                .andExpect(jsonPath("$[2].pages.[2].pageName").value("PAGE_HOME"));
    }

    @Test
    void getTarget_TargetContentAndReturnIt() throws Exception {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(1);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/content/target"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].target", hasSize(3)))
                .andExpect(jsonPath("$[0].page").value("PAGE_HOME"))
                .andExpect(jsonPath("$[0].startDate").value(startDate.toString()))
                .andExpect(jsonPath("$[0].endDate").value(endDate.toString()))

                .andExpect(jsonPath("$[0].target.[0].offers", hasSize(2)))
                .andExpect(jsonPath("$[0].target.[0].userGuid").value("00000000-0000-0000-0000-000000000000"))
                .andExpect(jsonPath("$[0].target.[0].offers.[0].contentGuid").value("10000000-0000-0000-0000-000000000000"))
                .andExpect(jsonPath("$[0].target.[0].offers.[1].contentGuid").value("20000000-0000-0000-0000-000000000000"))

                .andExpect(jsonPath("$[0].target.[1].offers", hasSize(2)))
                .andExpect(jsonPath("$[0].target.[1].userGuid").value("10000000-0000-0000-0000-000000000000"))
                .andExpect(jsonPath("$[0].target.[1].offers.[0].contentGuid").value("00000000-0000-0000-0000-000000000000"))
                .andExpect(jsonPath("$[0].target.[1].offers.[1].contentGuid").value("20000000-0000-0000-0000-000000000000"))

                .andExpect(jsonPath("$[0].target.[2].offers", hasSize(2)))
                .andExpect(jsonPath("$[0].target.[2].userGuid").value("20000000-0000-0000-0000-000000000000"))
                .andExpect(jsonPath("$[0].target.[2].offers.[0].contentGuid").value("00000000-0000-0000-0000-000000000000"))
                .andExpect(jsonPath("$[0].target.[2].offers.[1].contentGuid").value("10000000-0000-0000-0000-000000000000"));
    }
}