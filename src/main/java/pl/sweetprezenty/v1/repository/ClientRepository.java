package pl.sweetprezenty.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sweetprezenty.v1.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
