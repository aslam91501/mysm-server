package com.mysm.server.post.entity;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable @AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Tag {
    @Getter 
    private String name;
}
