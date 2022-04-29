package com.wenjin.studyneo4j.entity.node;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Person")
@Data
public class PersonEntity {

    @Id
    private Long id;

    private String name;

    private Integer born;

    public PersonEntity(Integer born, String name) {
        this.born = born;
        this.name = name;
    }


}