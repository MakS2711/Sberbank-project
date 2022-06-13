package ru.dorofeev.sberbankproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dorofeev.sberbankproject.model.Viewed;

import java.util.List;

@Repository
public interface ViewedRepository extends JpaRepository<Viewed, Long> {
    List<Viewed> findAllByUserId(Long user_id);
}
