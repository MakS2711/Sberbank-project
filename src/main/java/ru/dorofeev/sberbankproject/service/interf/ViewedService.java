package ru.dorofeev.sberbankproject.service.interf;

import ru.dorofeev.sberbankproject.model.Viewed;

import java.util.List;
import java.util.UUID;

public interface ViewedService extends AbstractService<Viewed> {
    List<Viewed> getInfoAboutAllViews();
    List<Viewed> getInfoByIdUserAboutViews(UUID id);



}
