package ru.dorofeev.sberbankproject.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность просмотренного контента")
public class ViewedDto {

    @Schema(description = "Идентификатор пользователя", example = "b1e599a3-54b3-4871-bdd9-c8849e5388e1")
    private UUID userGuid;

    @Schema(description = "Идентификатор просмотренного контента", example = "7a00310c-8cc9-4624-a656-f23026dfec3b")
    private UUID contentGuid;

}
