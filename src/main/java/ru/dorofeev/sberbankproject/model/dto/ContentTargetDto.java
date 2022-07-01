package ru.dorofeev.sberbankproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentTargetDto {
    private String page;

    private String startDate;

    private String endDate;

    List<TargetDto> target;
}
