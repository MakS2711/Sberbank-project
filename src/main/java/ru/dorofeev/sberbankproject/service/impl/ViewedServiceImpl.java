package ru.dorofeev.sberbankproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.dorofeev.sberbankproject.model.Viewed;
import ru.dorofeev.sberbankproject.repository.ViewedRepository;
import ru.dorofeev.sberbankproject.service.interf.ViewedService;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ViewedServiceImpl implements ViewedService {
    private final ViewedRepository viewedRepository;

    @Override
    public void save(List<Viewed> viewedList) {
        viewedRepository.saveAll(viewedList);

        log.info("IN saveAll() - count views: {} saved", viewedList.size());
    }

    @Override
    public List<Viewed> getInfoAboutAllViews() {
        log.info("IN getInfoAboutViews() - returned the information about all views");

        return viewedRepository.findAll();
    }

    @Override
    public List<Viewed> getInfoByIdUserAboutViews(UUID id) {
        log.info("IN getInfoByIdUserAboutViews() - returned the information by id user: {} about views", id);

        return viewedRepository.findAllByUserId(id);
    }
}
