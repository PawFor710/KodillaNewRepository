package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloValidatorTest {

    @Autowired
    private TrelloValidator trelloValidator;

    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloValidatorTest.class);

    @Test
    void validateCardTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("test", "test", "test", "test");

        //When
        trelloValidator.validateCard(trelloCard);

    }

    @Test
    void validateTrelloBoardsTest() {
        //Given
        TrelloList trelloList = new TrelloList("test", "test", true);
        List<TrelloList> trelloLists = List.of(trelloList);

        TrelloBoard trelloBoard = new TrelloBoard("test", "test", trelloLists);
        List<TrelloBoard> trelloBoards = List.of(trelloBoard);

        //When
        int result = trelloValidator.validateTrelloBoards(trelloBoards).size();

        //Then
        assertEquals(0, result);

    }



}