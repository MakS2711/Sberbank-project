package ru.dorofeev.sberbankproject.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dorofeev.sberbankproject.model.Users;
import ru.dorofeev.sberbankproject.repository.UsersRepository;
import ru.dorofeev.sberbankproject.service.interf.UsersService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public void save(List<Users> users) {
        log.info("IN save() - count users: {} saved", users.size());

        usersRepository.saveAll(users);
    }
}
