package ru.team1419.SpringPatterns;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeRepository extends JpaRepository<Coffe, Integer> {
}
