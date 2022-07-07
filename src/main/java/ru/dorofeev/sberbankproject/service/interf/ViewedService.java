package ru.dorofeev.sberbankproject.service.interf;

import ru.dorofeev.sberbankproject.model.Viewed;

import java.util.List;
import java.util.UUID;

public interface ViewedService extends AbstractService<Viewed> {
    /**
     * @return возвращает весь просмотренный контент всех пользователей.
     */
    List<Viewed> getInfoAboutAllViews();

    /**
     * @param id пользователя, по которому совершается поиск.
     * @return возвращает просмотренный контент определенного пользователя.
     */
    List<Viewed> getInfoByIdUserAboutViews(UUID id);



}
