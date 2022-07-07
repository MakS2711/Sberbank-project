package ru.dorofeev.sberbankproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.dorofeev.sberbankproject.model.Content;
import ru.dorofeev.sberbankproject.repository.ContentRepository;
import ru.dorofeev.sberbankproject.service.interf.ContentService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {
    private final ContentRepository contentRepository;

    @Override
    public void save(List<Content> content) {

        contentRepository.saveAll(content);

        log.info("IN save() - count content: {} saved", content.size());
    }

    public List<Content> getAll() {
        log.info("IN getInfoAboutViews() - returned the information about all views");

        return contentRepository.findAll();
    }
}
