package org.revo.Domain;

import lombok.Getter;

@Getter
public enum Queue {
    FFMPEG("FFMPEG", 2),
    FILE("FILE", 3),
    TUBE_PUBLISH("TUBE_PUBLISH", 4),
    TUBE_STORE("TUBE_STORE", 5);


    private String name;
    private int state;

    Queue(String name, int state) {
        this.name = name;
        this.state = state;
    }

}
