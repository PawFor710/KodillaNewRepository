package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;



    @Test
    public void mapToBoardsTest() {
        //Given
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("test1", "test1", new ArrayList<>());
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("test2", "test2", new ArrayList<>());
        TrelloBoardDto trelloBoardDto3 = new TrelloBoardDto("test3", "test3", new ArrayList<>());

        List<TrelloBoardDto> trelloBoardDtoTestList = new ArrayList<>();
        trelloBoardDtoTestList.add(trelloBoardDto1);
        trelloBoardDtoTestList.add(trelloBoardDto2);
        trelloBoardDtoTestList.add(trelloBoardDto3);

        //When
        List<TrelloBoard> result = trelloMapper.mapToBoards(trelloBoardDtoTestList);
        TrelloBoard trelloBoard = new TrelloBoard();

        //Then
        assertTrue(result.get(0).getClass().isInstance(trelloBoard));
    }

    @Test
    public void mapToBoardsDtoTest() {
        //Given
        TrelloBoard trelloBoard1 = new TrelloBoard("test1", "test1", new ArrayList<>());
        TrelloBoard trelloBoard2 = new TrelloBoard("test2", "test2", new ArrayList<>());
        TrelloBoard trelloBoard3 = new TrelloBoard("test3", "test3", new ArrayList<>());

        List<TrelloBoard> trelloBoardTestList = new ArrayList<>();
        trelloBoardTestList.add(trelloBoard1);
        trelloBoardTestList.add(trelloBoard2);
        trelloBoardTestList.add(trelloBoard3);

        //When
        List<TrelloBoardDto> result = trelloMapper.mapToBoardsDto(trelloBoardTestList);
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto();

        //Then
        assertTrue(result.get(0).getClass().isInstance(trelloBoardDto));
    }

    @Test
    public void mapToListTest() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("test1", "test1", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("test2", "test2", true);
        TrelloListDto trelloListDto3 = new TrelloListDto("test3", "test3", true);

        List<TrelloListDto> trelloListDtoTest = new ArrayList<>();
        trelloListDtoTest.add(trelloListDto1);
        trelloListDtoTest.add(trelloListDto2);
        trelloListDtoTest.add(trelloListDto3);

        //When
        List<TrelloList> result = trelloMapper.mapToList(trelloListDtoTest);
        TrelloList trelloList = new TrelloList();

        //Then
        assertTrue(result.get(0).getClass().isInstance(trelloList));
    }

    @Test
    public void mapToListDtoTest() {
        //Given
        TrelloList trelloList1 = new TrelloList("test1", "test1", true);
        TrelloList trelloList2 = new TrelloList("test2", "test2", true);
        TrelloList trelloList3 = new TrelloList("test3", "test3", true);

        List<TrelloList> trelloListTest = new ArrayList<>();
        trelloListTest.add(trelloList1);
        trelloListTest.add(trelloList2);
        trelloListTest.add(trelloList3);

        //When
        List<TrelloListDto> result = trelloMapper.mapToListDto(trelloListTest);
        TrelloListDto trelloListDto = new TrelloListDto();

        //Then
        assertTrue(result.get(0).getClass().isInstance(trelloListDto));
    }
}
