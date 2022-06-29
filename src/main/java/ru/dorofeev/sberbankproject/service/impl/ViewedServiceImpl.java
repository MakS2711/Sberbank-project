package ru.dorofeev.sberbankproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dorofeev.sberbankproject.model.Content;
import ru.dorofeev.sberbankproject.model.Users;
import ru.dorofeev.sberbankproject.model.Viewed;
import ru.dorofeev.sberbankproject.repository.ContentRepository;
import ru.dorofeev.sberbankproject.repository.UsersRepository;
import ru.dorofeev.sberbankproject.repository.ViewedRepository;
import ru.dorofeev.sberbankproject.service.interf.ViewedService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ViewedServiceImpl implements ViewedService {
    private final ViewedRepository viewedRepository;
    @Transactional
    @Override
    public void save(List<Viewed> viewedList) {
        log.info("IN saveAll() - count views: {} saved", viewedList.size());

        viewedRepository.saveAll(viewedList);
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
