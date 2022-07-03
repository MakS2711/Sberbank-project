package ru.dorofeev.sberbankproject.exception.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Schema(description = "Сущность ошибки отсутствия страницы")
public class ErrorPageResponse {
    @Schema(description = "Статус ошибки", example = "500")
    private final int status;

    @Schema(description = "Сообщение ошибки", example = "Данной страницы не существует!")
    private final String message;
}
