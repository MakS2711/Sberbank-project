package ru.dorofeev.sberbankproject.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность контента")
public class ContentDto {
    @Schema(description = "Идентификатор контента", example = "592c29b7-0157-4985-b6b4-43d84b210bd2")
    private UUID contentGuid;

    @Schema(description = "Список страниц, к которым принадлежит данный контент")
    private Set<PageDto> pages;
}
