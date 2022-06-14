package ru.dorofeev.sberbankproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dorofeev.sberbankproject.model.Viewed;

import java.util.List;
import java.util.UUID;

@Repository
public interface ViewedRepository extends JpaRepository<Viewed, UUID> {
    List<Viewed> findAllByUserId(UUID user_id);
}
