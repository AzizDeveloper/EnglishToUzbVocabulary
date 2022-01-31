package com.aziz.vocabulary.controllers;

import com.aziz.vocabulary.entities.Word;
import com.aziz.vocabulary.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WordController {

    @Autowired
    private WordRepository wordRepository;

    @GetMapping("/words")
    public String getAllWords(Model model) {
        model.addAttribute("words", wordRepository.findAll());
        return "words";
    }

    @PostMapping("/add-word")
    public String createWord(@ModelAttribute(value = "word") Word word) {
        wordRepository.save(word);
        System.out.println(word.getId());
        System.out.println(word.getEnglishWord());
        System.out.println(word.getUzbekWord());
        System.out.println(word.getSentence());
        return "redirect:/words";
    }

    @GetMapping("/edit-word-form")
    public String toEditWordForm() {
        return "word-edit";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(Model model, @PathVariable(value = "id") Long id) {
        Word word = getById(id);
        model.addAttribute("word", word);
        return "word-edit";
    }

    public Word getById(Long id) {
        return wordRepository.findById(id).orElse(null);
    }

    @GetMapping("/edit-word/{id}")
    public String editWord(@ModelAttribute(value = "product") Word word) {
        Word dbWord = getById(word.getId());
        System.out.println(word.getId());
        System.out.println(word.getEnglishWord());
        System.out.println(word.getUzbekWord());
        System.out.println(word.getSentence());
        dbWord.setUzbekWord(word.getUzbekWord());
        dbWord.setEnglishWord(word.getEnglishWord());
        dbWord.setSentence(word.getSentence());
        wordRepository.save(word);
        return "redirect:/words";
    }

    @GetMapping("/delete-word/{id}")
    public String deleteWord(@PathVariable Long id) {
        wordRepository.deleteById(id);
        System.out.println("Delete tugmasi bosildi");
        return "redirect:/words";
    }

}
