package ru.dorofeev.sberbankproject.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность страницы")
public class PageDto {
    @Schema(description = "Название страницы", example = "PAGE_HOME")
    private String pageName;
}
