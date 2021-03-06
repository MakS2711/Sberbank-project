package ru.dorofeev.sberbankproject.service.interf;

import java.util.List;

public interface AbstractService<T> {
    /**
     * Метод позволяет сохранить список объектов с типом T.
     * @param t сохраняемый список.
     */
    void save(List<T> t);

}
