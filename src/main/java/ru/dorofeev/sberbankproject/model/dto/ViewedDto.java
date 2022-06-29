package ru.dorofeev.sberbankproject.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ViewedDto {
    private UUID userGuid;

    private UUID contentGuid;

}
