package com.wenjin.studyneo4j.entity.node;

import java.util.ArrayList;
import java.util.List;

import com.wenjin.studyneo4j.entity.relationship.Roles;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

@Node(labels = "Movie")
@Data
public class MovieEntity {
        @Id @GeneratedValue
        private Long id;

        private final String title;

        @Property("tagline")
        private final String description;

        @Relationship(type = "ACTED_IN", direction = Direction.INCOMING)
        private List<Roles> actorsAndRoles;

        @Relationship(type = "DIRECTED", direction = Direction.INCOMING)
        private List<PersonEntity> directors = new ArrayList<>();

        public MovieEntity(String title, String description) {
                this.title = title;
                this.description = description;
        }

        // Getters omitted for brevity
}