package ru.dorofeev.sberbankproject.service.interf;

import ru.dorofeev.sberbankproject.model.Viewed;

import java.util.List;

public interface ViewedService {
    List<Viewed> getInfoAboutAllViews();

    List<Viewed> getInfoByIdUserAboutViews(Long id);
}
