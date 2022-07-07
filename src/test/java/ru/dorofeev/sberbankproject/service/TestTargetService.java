package ru.dorofeev.sberbankproject.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import ru.dorofeev.sberbankproject.model.dto.ContentTargetDto;
import ru.dorofeev.sberbankproject.service.interf.TargetService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@TestPropertySource("/application-test.properties")
@Sql(value = {"/sql/insert-data-for-content.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/sql/delete-data-for-content.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class TestTargetService {
    @Autowired
    private TargetService targetService;

    @Test
    public void checkServiceIsNotNull_ReturnNotNull() {
        Assertions.assertNotNull(targetService);
    }

    @Test
    void getTarget_TargetContentAndReturnIt() {
        List<ContentTargetDto> targetContentList = targetService.getTargetContentList();
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(1);

        Assertions.assertNotNull(targetContentList);
        Assertions.assertEquals("PAGE_HOME", targetContentList.get(0).getPage());
        Assertions.assertEquals(startDate.toString(), targetContentList.get(0).getStartDate());
        Assertions.assertEquals(endDate.toString(), targetContentList.get(0).getEndDate());
        Assertions.assertNotNull(targetContentList.get(0).getTarget());
        Assertions.assertNotNull(targetContentList.get(0).getTarget().get(0).getOffers());
        Assertions.assertEquals(3, targetService.getTargetContentList().get(0).getTarget().size());
        Assertions.assertEquals(2, targetService.getTargetContentList().get(0).getTarget().get(0).getOffers().size());

        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"),
                targetService.getTargetContentList().get(0).getTarget().get(0).getUserGuid());
        Assertions.assertEquals(UUID.fromString("10000000-0000-0000-0000-000000000000"),
                targetService.getTargetContentList().get(0).getTarget().get(0).getOffers().get(0).getContentGuid());
        Assertions.assertEquals(UUID.fromString("20000000-0000-0000-0000-000000000000"),
                targetService.getTargetContentList().get(0).getTarget().get(0).getOffers().get(1).getContentGuid());

        Assertions.assertEquals(UUID.fromString("10000000-0000-0000-0000-000000000000"),
                targetService.getTargetContentList().get(0).getTarget().get(1).getUserGuid());
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"),
                targetService.getTargetContentList().get(0).getTarget().get(1).getOffers().get(0).getContentGuid());
        Assertions.assertEquals(UUID.fromString("20000000-0000-0000-0000-000000000000"),
                targetService.getTargetContentList().get(0).getTarget().get(1).getOffers().get(1).getContentGuid());

        Assertions.assertEquals(UUID.fromString("20000000-0000-0000-0000-000000000000"),
                targetService.getTargetContentList().get(0).getTarget().get(2).getUserGuid());
        Assertions.assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000000"),
                targetService.getTargetContentList().get(0).getTarget().get(2).getOffers().get(0).getContentGuid());
        Assertions.assertEquals(UUID.fromString("10000000-0000-0000-0000-000000000000"),
                targetService.getTargetContentList().get(0).getTarget().get(2).getOffers().get(1).getContentGuid());
    }
}