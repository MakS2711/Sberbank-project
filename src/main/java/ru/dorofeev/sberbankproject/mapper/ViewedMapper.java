package ru.dorofeev.sberbankproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.dorofeev.sberbankproject.model.Viewed;
import ru.dorofeev.sberbankproject.model.dto.ViewedDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ViewedMapper {
    @Mappings({
            @Mapping(source = "user.id", target = "userGuid"),
            @Mapping(source = "content.id", target = "contentGuid"),
    })
    List<ViewedDto> toDtoList(List<Viewed> viewed);

    @Mappings({
            @Mapping(source = "userGuid", target = "user.id"),
            @Mapping(source = "contentGuid", target = "content.id"),
    })
    List<Viewed> toViewedList(List<ViewedDto> viewedDto);

    @Mappings({
            @Mapping(source = "user.id", target = "userGuid"),
            @Mapping(source = "content.id", target = "contentGuid"),
    })
    ViewedDto toDto(Viewed viewed);

    @Mappings({
            @Mapping(source = "userGuid", target = "user.id"),
            @Mapping(source = "contentGuid", target = "content.id"),
    })
    Viewed toViewed(ViewedDto viewedDto);
}
