package ru.dorofeev.sberbankproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dorofeev.sberbankproject.model.Content;
import ru.dorofeev.sberbankproject.service.interf.ContentService;


@RestController
@RequestMapping("/api/v1/content")
@RequiredArgsConstructor
@Tag(name = "Content Controller", description = "Управляет контентом")
public class ContentController implements AbstractController<Content> {
    private final ContentService contentService;

    @Operation(
            summary = "Сохранение контента",
            description = "Позволяет сохранить информацию о контенте от CMS"
    )
    @PostMapping("/save")
    public void save(@RequestBody Content content) {
        contentService.save(content);
    }

}
