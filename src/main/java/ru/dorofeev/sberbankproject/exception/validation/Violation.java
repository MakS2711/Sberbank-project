package ru.dorofeev.sberbankproject.exception.validation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Schema(description = "Сущность ошибки валидации")
public class Violation {
    @Schema(description = "Поле с ошибкой", example = "pageName")
    private final String fieldName;

    @Schema(description = "Сообщение ошибки", example = "Поле не должно быть пустым!")
    private final String message;
}
