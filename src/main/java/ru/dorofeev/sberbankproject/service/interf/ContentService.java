package ru.dorofeev.sberbankproject.service.interf;

import ru.dorofeev.sberbankproject.model.Content;

import java.util.List;

public interface ContentService extends AbstractService<Content>{
    List<Content> getAll();
}
