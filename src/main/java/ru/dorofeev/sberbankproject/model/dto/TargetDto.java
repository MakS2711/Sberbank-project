package ru.dorofeev.sberbankproject.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность идентификатора пользователя с непросмотренным контентом")
public class TargetDto {
    @Schema(description = "Идентификатор пользователя", example = "49ea8a58-fff9-43d1-aae6-eec8ca393e58")
    private UUID userGuid;

    @Schema(description = "Список непросмотренного контента пользователем")
    List<OfferDto> offers;

}
