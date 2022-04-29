package com.wenjin.studyneo4j.entity.relationship;

import com.wenjin.studyneo4j.entity.node.PersonEntity;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.List;

@RelationshipProperties
@Data
public class Roles {

        @RelationshipId
        private Long id;

        private final List<String> roles;

        @TargetNode
        private final PersonEntity person;

        public Roles(PersonEntity person, List<String> roles) {
                this.person = person;
                this.roles = roles;
        }

        public List<String> getRoles() {
                return roles;
        }
}