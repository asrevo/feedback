package org.revo.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Master extends Base {
    private String image;
    private String secret;
    private String file;
    private double time;
    private String resolution;
    private String keys;
}