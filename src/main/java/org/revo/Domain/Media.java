package org.revo.Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by ashraf on 15/04/17.
 */
@Getter
@Setter
public class Media {
    private String id;
    private String title;
    private String image;
    private double time;
    private String meta;
    private String secret;
    private Status status = Status.BINDING;
    private String userId;
    private User user;
    private Date createdDate = new Date();
    private Date publishDate = new Date();
    private String url;
    private String group;
}