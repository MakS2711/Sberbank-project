package ru.dorofeev.sberbankproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dorofeev.sberbankproject.model.Users;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {

}
