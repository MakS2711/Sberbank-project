package ru.dorofeev.sberbankproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dorofeev.sberbankproject.mapper.ContentMapper;
import ru.dorofeev.sberbankproject.model.dto.ContentDto;
import ru.dorofeev.sberbankproject.model.dto.ContentTargetDto;
import ru.dorofeev.sberbankproject.service.interf.ContentService;
import ru.dorofeev.sberbankproject.service.interf.TargetService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/content")
@RequiredArgsConstructor
@Tag(name = "Content Controller", description = "Управляет контентом")
public class ContentController implements AbstractController<ContentDto> {
    private final ContentService contentService;
    private final ContentMapper contentMapper;
    private final TargetService targetService;

    @Operation(
            summary = "Сохранение контента",
            description = "Позволяет сохранить информацию о контенте от CMS"
    )
    @PostMapping("/save")
    public void save(@RequestBody List<ContentDto> contentDto) {
        contentService.save(contentMapper.toContentList(contentDto));
    }

    @Operation(
            summary = "Показ сохраненного контента",
            description = "Возвращает список сохраненного контента"
    )
    @GetMapping()
    public List<ContentDto> getAll() {
        return contentMapper.toDtoList(contentService.getAll());
    }

    @Operation(
            summary = "Таргетирование контента",
            description = "Позволяет получить таргетированный контент"
    )
    @GetMapping("/target")
    public List<ContentTargetDto> getTarget() {
        return targetService.getTargetContentList();
    }
}
