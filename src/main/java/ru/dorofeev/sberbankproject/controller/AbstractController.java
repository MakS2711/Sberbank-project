package ru.dorofeev.sberbankproject.controller;

import java.util.List;

public interface AbstractController<T> {
    void save(List<T> t);
}
