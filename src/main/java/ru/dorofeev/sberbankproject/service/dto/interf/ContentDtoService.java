package ru.dorofeev.sberbankproject.service.dto.interf;

import ru.dorofeev.sberbankproject.model.dto.ContentDto;

import java.util.List;

public interface ContentDtoService extends AbstractDtoService<ContentDto> {
    /**
     * Является service-прослойкой, существующей для преобразования entity в dto.
     *
     * @return возвращает список сохраненного контента.
     */
    List<ContentDto> getAll();
}
