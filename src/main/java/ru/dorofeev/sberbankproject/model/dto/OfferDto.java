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
@Schema(description = "Сущность идентификатора контента с приоритетом просмотра")
public class OfferDto {
    @Schema(description = "Идентификатор контента", example = "44d13fd0-5cb1-4a64-a095-38a321d21f81")
    private UUID contentGuid;

    @Schema(description = "Приоритет просмотра от 1 до 100", accessMode = Schema.AccessMode.READ_ONLY)
    byte priority;
}

