package ru.dorofeev.sberbankproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dorofeev.sberbankproject.model.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

}
