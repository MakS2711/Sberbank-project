package ru.dorofeev.sberbankproject.service.interf;

import java.util.List;

public interface AbstractService<T> {
    void save(List<T> t);

}
