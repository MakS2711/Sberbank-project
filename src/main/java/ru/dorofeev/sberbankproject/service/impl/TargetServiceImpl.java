package ru.dorofeev.sberbankproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.dorofeev.sberbankproject.model.Content;
import ru.dorofeev.sberbankproject.model.Page;
import ru.dorofeev.sberbankproject.model.Users;
import ru.dorofeev.sberbankproject.model.Viewed;
import ru.dorofeev.sberbankproject.model.dto.ContentTargetDto;
import ru.dorofeev.sberbankproject.model.dto.OfferDto;
import ru.dorofeev.sberbankproject.model.dto.TargetDto;
import ru.dorofeev.sberbankproject.repository.PageRepository;
import ru.dorofeev.sberbankproject.repository.UsersRepository;
import ru.dorofeev.sberbankproject.repository.ViewedRepository;
import ru.dorofeev.sberbankproject.service.interf.TargetService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class TargetServiceImpl implements TargetService {
    private final int MAX_PRIORITY_CONTENT = 100;
    private final int MIN_PRIORITY_CONTENT = 1;
    private final int SENDING_EVERY_24_HOURS_TO_CDS = 24 * 60 * 60 * 1000; //86_400_000ms.
    private final PageRepository pageRepository;
    private final ViewedRepository viewedRepository;
    private final UsersRepository usersRepository;
    private final Random getPriorityContentRandom;
    private final WebClient webClient;

    @Scheduled(fixedRate = SENDING_EVERY_24_HOURS_TO_CDS)
    private void getTargetContent() {
        List<ContentTargetDto> result = getTargetContentList();

        for (ContentTargetDto item : result) {
            webClient
                    .post()
                    .body(Mono.just(item), ContentTargetDto.class)
                    .retrieve()
                    .onStatus(HttpStatus::is4xxClientError, error -> {
                        log.error("API not found");
                        return Mono.error(new RuntimeException("API not found"));
                    })
                    .onStatus(HttpStatus::is5xxServerError, error -> {
                        log.error("Server is not responding");
                        return Mono.error(new RuntimeException("Server is not responding"));
                    })
                    .bodyToMono(ContentTargetDto.class)
                    .block();
        }

    }

    @Override
    public List<ContentTargetDto> getTargetContentList() {
        List<ContentTargetDto> result = new ArrayList<>();
        List<Page> pages = pageRepository.findAll();
        List<Users> users = usersRepository.findAll();

        for (Page page : pages) {
            LocalDate startDate = LocalDate.now();
            LocalDate endDate = startDate.plusDays(1);

            List<Content> allContentPage = page.getContents();
            List<TargetDto> targetDtoList = new ArrayList<>();

            for (Users user : users) {
                TargetDto targetDto = new TargetDto();
                targetDto.setUserGuid(user.getId());
                List<Viewed> viewed = viewedRepository.findAllByUserId(user.getId());
                List<Content> viewedContents = new ArrayList<>();

                for (Viewed item : viewed) {
                    viewedContents.add(item.getContent());
                }

                for (Content item : viewedContents) {
                    allContentPage.remove(item);
                }

                List<OfferDto> listOffer = new ArrayList<>();

                for (Content sortedContent : allContentPage) {
                    listOffer.add(OfferDto.builder()
                            .contentGuid(sortedContent.getId())
                            .priority((byte) (getPriorityContentRandom.nextInt((MAX_PRIORITY_CONTENT + 1) - MIN_PRIORITY_CONTENT) + MIN_PRIORITY_CONTENT))
                            .build()
                    );
                }

                targetDto.setOffers(listOffer);

                targetDtoList.add(targetDto);
            }

            result.add(ContentTargetDto.builder()
                    .page(page.getName())
                    .startDate(startDate.toString())
                    .endDate(endDate.toString())
                    .target(targetDtoList)
                    .build());
        }

        return result;
    }
}
