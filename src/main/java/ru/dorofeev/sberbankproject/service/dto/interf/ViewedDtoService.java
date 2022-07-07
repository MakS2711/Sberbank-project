package ru.dorofeev.sberbankproject.service.dto.interf;

import ru.dorofeev.sberbankproject.model.dto.ViewedDto;

import java.util.List;
import java.util.UUID;

public interface ViewedDtoService extends AbstractDtoService<ViewedDto> {
    /**
     * Является service-прослойкой, существующей для преобразования entity в dto.
     *
     * @return возвращает весь просмотренный контент всех пользователей.
     */
    List<ViewedDto> getInfoAboutAllViews();

    /**
     * Является service-прослойкой, существующей для преобразования entity в dto.
     *
     * @param id пользователя, по которому совершается поиск.
     * @return возвращает просмотренный контент определенного пользователя.
     */
    List<ViewedDto> getInfoByIdUserAboutViews(UUID id);
}