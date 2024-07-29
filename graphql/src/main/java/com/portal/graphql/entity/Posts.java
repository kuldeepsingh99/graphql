package com.portal.graphql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "no_of_likes")
    private int noOfLikes;

    @Column(name = "is_display")
    private boolean isDisplay;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private List<PostComments> comments = new ArrayList<>();


    public Posts(String name, String content, int noOfLikes, boolean display) {
        this.name = name;
        this.content = content;
        this.noOfLikes = noOfLikes;
        this.isDisplay = display;
    }
}
