package ru.dorofeev.sberbankproject.service.dto.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.dorofeev.sberbankproject.mapper.ViewedMapper;
import ru.dorofeev.sberbankproject.model.dto.ViewedDto;
import ru.dorofeev.sberbankproject.service.dto.interf.ViewedDtoService;
import ru.dorofeev.sberbankproject.service.interf.ViewedService;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ViewedDtoServiceImpl implements ViewedDtoService {

    private final ViewedService viewedService;
    private final ViewedMapper viewedMapper;

    @Override
    public void save(List<ViewedDto> viewedDto) {
        viewedService.save(viewedMapper.toViewedList(viewedDto));

        log.info("IN save() - Converting dto into entity.");
    }

    @Override
    public List<ViewedDto> getInfoAboutAllViews() {

        log.info("IN getInfoAboutAllViews() - Converting entity into dto.");

        return viewedMapper.toDtoList(viewedService.getInfoAboutAllViews());
    }

    @Override
    public List<ViewedDto> getInfoByIdUserAboutViews(UUID id) {

        log.info("IN getInfoByIdUserAboutViews() - Converting entity into dto.");

        return viewedMapper.toDtoList(viewedService.getInfoByIdUserAboutViews(id));
    }
}
