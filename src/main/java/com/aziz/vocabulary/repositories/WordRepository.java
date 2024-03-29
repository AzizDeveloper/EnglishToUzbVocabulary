package com.aziz.vocabulary.repositories;

import com.aziz.vocabulary.entities.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    Optional<Word> findById(Long id);

//    Word findById(Long id);

//    List<Word> findAll();
//
//    @Query(nativeQuery = true, value = "SELECT english_word, uzbek_word, sentence  FROM words;")
//    List<Word> findAllMy();

//    public List<Word> getByUzbekWord();
//
//    public List<Word> getBySentence();

}
