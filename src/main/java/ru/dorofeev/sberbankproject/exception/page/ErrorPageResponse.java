package ru.dorofeev.sberbankproject.exception.page;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorPageResponse {
    private final int status;
    private final String message;
}
