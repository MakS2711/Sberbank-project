package ru.dorofeev.sberbankproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.dorofeev.sberbankproject.model.Content;
import ru.dorofeev.sberbankproject.repository.ContentRepository;
import ru.dorofeev.sberbankproject.service.interf.ContentService;


@Service
@Slf4j
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {
    private final ContentRepository contentRepository;

    @Override
    public void save(Content content) {
        log.info("IN save() - content with id: {} saved", content.getId());

        contentRepository.save(content);
    }
}
