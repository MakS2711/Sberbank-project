package ru.dorofeev.sberbankproject.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Schema(description = "Сущность таргетированного контента")
public class ContentTargetDto {
    @Schema(description = "Название страницы, на которую приходится таргетирование", example = "PAGE_HOME")
    private String page;

    @Schema(description = "Начало срока действия кампания", example = "1995-05-23")
    private String startDate;

    @Schema(description = "Конец срока действия кампания", example = "1995-05-24")
    private String endDate;

    @Schema(description = "Список непросмотренного контента для пользователя")
    List<TargetDto> target;
}
