package ru.dorofeev.stubproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dorofeev.stubproject.model.ContentTargetDto;

import java.util.UUID;

public interface TargetRepository extends JpaRepository<ContentTargetDto, UUID> {

}
