package ru.dorofeev.sberbankproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dorofeev.sberbankproject.model.dto.ViewedDto;
import ru.dorofeev.sberbankproject.service.dto.interf.ViewedDtoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/viewed")
@RequiredArgsConstructor
@Tag(name = "Viewed Controller", description = "Управляет просмотрами рекламы")
public class ViewedController implements AbstractController<ViewedDto> {
    private final ViewedDtoService viewedDtoService;

    @Operation(
            summary = "Сохранение просмотров",
            description = "Позволяет сохранить информацию о просмотрах пользователя"
    )
    @PostMapping("/save")
    public void save(@RequestBody List<ViewedDto> viewedDto) {
        viewedDtoService.save(viewedDto);
    }

    @Operation(
            summary = "Получение информации о всех просмотрах",
            description = "Позволяет получить информации о всех просмотрах рекламы"
    )
    @GetMapping()
    public List<ViewedDto> getInfoAboutAllViews() {
        return viewedDtoService.getInfoAboutAllViews();
    }

    @Operation(
            summary = "Получение информации о всех просмотрах конкретного пользователя",
            description = "Позволяет получить информации по ID пользователя о всех просмотрах рекламы"
    )
    @GetMapping("/{id}")
    public List<ViewedDto> getInfoByIdUserAboutViews(@PathVariable UUID id) {
        return viewedDtoService.getInfoByIdUserAboutViews(id);
    }
}
