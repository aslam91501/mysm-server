package com.mysm.server.comment.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.UUID) 
    @Getter
    private UUID id;

    @Getter
    private UUID authorId;

    @Getter
    private String commentBody;

    @Getter @Enumerated(EnumType.STRING)
    private CommentStatus status;

    @Getter
    private LocalDateTime dateTime;

    public Comment(UUID authorId, String commentBody, LocalDateTime dateTime) {
        this.authorId = authorId;
        this.commentBody = commentBody;
        this.dateTime = dateTime;

        this.status = CommentStatus.ACTIVE;
        this.dateTime = LocalDateTime.now();
    }


    
}
