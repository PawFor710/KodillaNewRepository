package com.crud.tasks.domain;

import lombok.Data;

@Data
public class TrelloNewDto {

    private String id;
    private String name;
    private String description;
    private String pos;
    private String listId;
    private Badges badges;
}
