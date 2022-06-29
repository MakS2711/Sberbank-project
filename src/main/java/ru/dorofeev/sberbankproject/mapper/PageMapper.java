package ru.dorofeev.sberbankproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.dorofeev.sberbankproject.model.Page;
import ru.dorofeev.sberbankproject.model.dto.PageDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PageMapper {
    @Mapping(source = "name", target = "pageName")
    List<PageDto> toDtoList(List<Page> pages);

    @Mapping(source = "pageName", target = "name")
    List<Page> toPageList(List<PageDto> pagesDto);

    @Mapping(source = "name", target = "pageName")
    PageDto toDto(Page pages);

    @Mapping(source = "pageName", target = "name")
    Page toPage(PageDto pagesDto);
}
