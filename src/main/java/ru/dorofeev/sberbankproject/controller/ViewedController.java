package ru.dorofeev.sberbankproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dorofeev.sberbankproject.model.Viewed;
import ru.dorofeev.sberbankproject.service.interf.ViewedService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/viewed")
@RequiredArgsConstructor
@Tag(name = "Viewed Controller", description = "Управляет просмотрами рекламы")
public class ViewedController {
    private final ViewedService viewedService;

    @Operation(
            summary = "Получение информации о всех просмотрах",
            description = "Позволяет получить информации о всех просмотрах рекламы"
    )
    @GetMapping()
    public List<Viewed> getInfoAboutAllViews() {
        return viewedService.getInfoAboutAllViews();
    }

    @Operation(
            summary = "Получение информации о всех просмотрах конкретного пользователя",
            description = "Позволяет получить информации по ID пользователя о всех просмотрах рекламы"
    )
    @GetMapping("/{id}")
    public List<Viewed> getInfoByIdUserAboutViews(@PathVariable UUID id) {
        return viewedService.getInfoByIdUserAboutViews(id);
    }
}
