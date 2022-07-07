package ru.dorofeev.sberbankproject.service.dto.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.dorofeev.sberbankproject.mapper.ContentMapper;
import ru.dorofeev.sberbankproject.model.dto.ContentDto;
import ru.dorofeev.sberbankproject.service.dto.interf.ContentDtoService;
import ru.dorofeev.sberbankproject.service.interf.ContentService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContentDtoServiceImpl implements ContentDtoService {
    private final ContentService contentService;

    private final ContentMapper contentMapper;

    @Override
    public void save(List<ContentDto> contentDto) {
        contentService.save(contentMapper.toContentList(contentDto));

        log.info("IN save() - Converting dto into entity.");
    }

    @Override
    public List<ContentDto> getAll() {

        log.info("IN getAll() - Converting entity into dto.");

        return contentMapper.toDtoList(contentService.getAll());
    }
}