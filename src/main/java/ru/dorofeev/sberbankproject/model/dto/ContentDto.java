package ru.dorofeev.sberbankproject.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class ContentDto {
    private UUID contentGuid;

    private Set<PageDto> pages;
}
