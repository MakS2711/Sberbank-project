package ru.dorofeev.sberbankproject.service.interf;

import ru.dorofeev.sberbankproject.model.dto.ContentTargetDto;

import java.util.List;

public interface TargetService {
    List<ContentTargetDto> getTargetContentList();
    void sendTargetContent();
}
