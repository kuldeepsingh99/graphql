package com.portal.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private String name;
    private String content;
    private int noOfLikes;
    private boolean isDisplay;
}
