package ru.dorofeev.sberbankproject.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.dorofeev.sberbankproject.model.Content;
import ru.dorofeev.sberbankproject.model.Page;
import ru.dorofeev.sberbankproject.model.dto.ContentDto;
import ru.dorofeev.sberbankproject.model.dto.PageDto;
import ru.dorofeev.sberbankproject.repository.PageRepository;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContentMapper {
    private final PageRepository pageRepository;

    public List<ContentDto> toDtoList(List<Content> content) {
        if (content == null) {
            return null;
        }

        List<ContentDto> result = new ArrayList<>(content.size());

        for (var item : content) {
            result.add(toDto(item));
        }

        return result;
    }

    public List<Content> toContentList(List<ContentDto> contentDto) {

        if (contentDto == null) {
            return null;
        }

        List<Content> result = new ArrayList<>(contentDto.size());

        for (var currentContent : contentDto) {
            Content content = new Content();
            Set<Page> pages = new HashSet<>();

            for (var pageDto : currentContent.getPages()) {
                List<Content> contents = new ArrayList<>();
                Optional<Page> pageFindByName = pageRepository.findByName(pageDto.getPageName());

                Page page;
                if (pageFindByName.isPresent()) {
                    page = pageFindByName.get();
                    contents.addAll(page.getContents());
                } else {
                    page = new Page();
                    page.setName(pageDto.getPageName());
                }

                contents.add(content);
                page.setContents(contents);
                pages.add(page);
            }

            content.setId(currentContent.getContentGuid());
            content.setPages(pages);
            result.add(content);
        }

        return result;
    }


    private ContentDto toDto(Content content) {
        if (content == null) {
            return null;
        }

        return ContentDto.builder()
                .contentGuid(content.getId())
                .pages(content.getPages().stream().map(page -> PageDto.builder()
                                .pageName(page.getName())
                                .build())
                        .collect(Collectors.toSet())
                )
                .build();
    }
}
