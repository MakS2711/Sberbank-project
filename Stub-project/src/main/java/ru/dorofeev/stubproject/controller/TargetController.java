package ru.dorofeev.stubproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dorofeev.stubproject.model.ContentTargetDto;
import ru.dorofeev.stubproject.service.TargetService;


@RestController
@RequestMapping("/api/v1/target")
@RequiredArgsConstructor
public class TargetController {

    private final TargetService targetService;

    @PostMapping("/save")
    public void save(@RequestBody ContentTargetDto targets) {
        targetService.save(targets);
    }
}
