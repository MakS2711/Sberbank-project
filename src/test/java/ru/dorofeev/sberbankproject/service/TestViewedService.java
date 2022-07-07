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
import ru.dorofeev.sberbankproject.model.Users;
import ru.dorofeev.sberbankproject.model.Viewed;
import ru.dorofeev.sberbankproject.service.interf.ViewedService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@TestPropertySource("/application-test.properties")
@Sql(value = {"/sql/insert-data-for-viewed.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/sql/delete-data-for-viewed.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class TestViewedService {
    @Autowired
    private ViewedService viewedService;

    private static List<Viewed> views;

    @BeforeAll
    public static void initializationListResul() {
        views = new ArrayList<>(List.of(
                Viewed.builder()
                        .content(
                                Content.builder()
                                        .id(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                                        .pages(new HashSet<>())
                                        .build()
                        )
                        .user(Users.builder()
                                .id(UUID.fromString("10000000-0000-0000-0000-000000000000"))
                                .build()
                        )
                        .build()
        ));
    }

    @Test
    public void checkServiceIsNotNull_ReturnNotNull() {
        Assertions.assertNotNull(viewedService);
    }

    @Test
    void save_SaveUserViewedContents() {
        viewedService.save(views);

        List<Viewed> savedContents = viewedService.getInfoAboutAllViews();

        Assertions.assertNotNull(savedContents);
        Assertions.assertEquals(4, savedContents.size());
        Assertions.assertEquals(views.get(0).getContent().getId(), savedContents.get(savedContents.size() - 1).getContent().getId());
        Assertions.assertEquals(views.get(0).getUser().getId(), savedContents.get(savedContents.size() - 1).getUser().getId());
    }

    @Test
    void getInfoAboutAllViews() {
        List<Viewed> returnedViewed = viewedService.getInfoAboutAllViews();

        Assertions.assertNotNull(returnedViewed);
        Assertions.assertEquals(3, returnedViewed.size());
    }

    @Test
    void getInfoByIdUserAboutViews() {
        UUID uuid = UUID.fromString("00000000-0000-0000-0000-000000000000");

        List<Viewed> returnedViewedById = viewedService.getInfoByIdUserAboutViews(uuid);

        Assertions.assertNotNull(returnedViewedById);
        Assertions.assertEquals(1, returnedViewedById.size());
    }
}