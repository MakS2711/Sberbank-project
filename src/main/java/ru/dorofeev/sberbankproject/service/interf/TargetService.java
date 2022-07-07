package ru.dorofeev.sberbankproject.service.interf;

import ru.dorofeev.sberbankproject.model.dto.ContentTargetDto;

import java.util.List;

public interface TargetService {
    /**
     * Метод отбирает контент для каждого пользователя, фильтруя его в соответствии с уже просмотренным им контентом.
     * Таргетирование происходит для каждой доступной страницы.
     *
     * @return возвращает список таргетированного контента, предназначенного определенной странице.
     */
    List<ContentTargetDto> getTargetContentList();

    /**
     * Отправление таргетированного контента раз в сутки на endpoint микросервиса "Content Delivery System".
     */
    void sendTargetContent();
}
