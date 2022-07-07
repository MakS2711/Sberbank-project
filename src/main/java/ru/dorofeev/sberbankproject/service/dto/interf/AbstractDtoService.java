package ru.dorofeev.sberbankproject.service.dto.interf;

import java.util.List;

public interface AbstractDtoService<T> {
    /**
     * Метод позволяет сохранить список объектов с типом T.
     *
     * @param t сохраняемый список.
     */
    void save(List<T> t);

}
