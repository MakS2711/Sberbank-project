package ru.dorofeev.sberbankproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dorofeev.sberbankproject.model.Page;
import ru.dorofeev.sberbankproject.model.Viewed;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PageRepository extends JpaRepository<Page, UUID> {
    Optional<Page> findByName(String name);
}
