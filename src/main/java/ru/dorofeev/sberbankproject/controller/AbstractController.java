package ru.dorofeev.sberbankproject.controller;

import ru.dorofeev.sberbankproject.model.Content;

public interface AbstractController<T> {
    void save(Content content);
}
