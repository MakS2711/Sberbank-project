package ru.dorofeev.sberbankproject.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import ru.dorofeev.sberbankproject.model.Content;
import ru.dorofeev.sberbankproject.service.interf.ContentService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@TestPropertySource("/application-test.properties")
@Sql(value = {"/sql/insert-data-for-content.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/sql/delete-data-for-content.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class TestContentService {
    @Autowired
    private ContentService contentService;

    private static List<Content> contents;

    @BeforeAll
    public static void initializationListResul() {
        contents = new ArrayList<>(List.of(
                Content.builder()
                        .id(UUID.fromString("99999999-0000-1111-0000-111111111111"))
                        .pages(new HashSet<>())
                        .build()
        ));
    }

    @Test
    public void checkServiceIsNotNull_ReturnNotNull() {
        Assertions.assertNotNull(contentService);
    }

    @Test
    public void save_SaveContents() {
        contentService.save(contents);

        List<Content> savedContents = contentService.getAll();

        Assertions.assertEquals(4, savedContents.size());
        Assertions.assertEquals(contents.get(0).getId(), savedContents.get(savedContents.size() - 1).getId());
    }

    @Test
    public void getAll_ReturnAllContent() {
        List<Content> returnedContent = contentService.getAll();

        Assertions.assertNotNull(returnedContent);
        Assertions.assertEquals(3, returnedContent.size());
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"), returnedContent.get(0).getId());


    }
}