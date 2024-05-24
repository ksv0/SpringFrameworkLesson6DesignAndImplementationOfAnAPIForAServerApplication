package com.example.example4sem6_rick_and_morty_rest.repo;

import com.example.example4sem6_rick_and_morty_rest.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterRepo extends JpaRepository<Card, Integer> {

}
