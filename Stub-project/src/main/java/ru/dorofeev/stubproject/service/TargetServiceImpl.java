package ru.dorofeev.stubproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dorofeev.stubproject.model.ContentTargetDto;
import ru.dorofeev.stubproject.repository.TargetRepository;

@Service
@RequiredArgsConstructor
public class TargetServiceImpl implements TargetService {

    private final TargetRepository targetRepository;

    @Override
    public void save(ContentTargetDto target) {
        targetRepository.save(target);
    }
}
