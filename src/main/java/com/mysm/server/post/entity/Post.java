package com.mysm.server.post.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.UUID) 
    @Getter
    private UUID id;

    @Getter
    private String title;

    @Getter 
    private UUID authorId;

    @Getter
    private LocalDateTime dateTime;

    @Getter
    private String imageLocation;

    @Getter
    private String content;

    @Getter @Enumerated(EnumType.STRING)
    private PostStatus status;

    @ElementCollection(fetch=FetchType.EAGER)
    private List<Tag> tags;

    public Post(String title, String imageLocation, String content, List<String> tagNames, UUID authorId) {
        this.title = title;
        this.imageLocation = imageLocation;
        this.content = content;
        this.authorId = authorId;

        this.status = PostStatus.ACTIVE;
        this.dateTime = LocalDateTime.now();

        tags = new ArrayList<>();

        tagNames.forEach(tagName -> addTag(new Tag(tagName)));
    }

    public void addTag(Tag tag){
        if(!tags.contains(tag))
            tags.add(tag);
    }

    public List<Tag> getTags(){
        return Collections.unmodifiableList(tags);
    }

    // public void addComment(Comment comment){
    //     Boolean commentExistsByUser = comments.stream()
    //         .anyMatch(c -> c.getAuthorId().equals(comment.getAuthorId()));

    //     if(!commentExistsByUser)
    //         comments.add(comment);
    //     else throw new IllegalActionException("A user cannot comment on a post twice!");
    // }

    // public List<Comment> getComments(){
    //     return Collections.unmodifiableList(comments);
    // }
}
