package org.revo.Domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
public class Stater {
    @Id
    private String id;
    private Queue queue;
    private State state;
    private Media media;
    @CreatedDate
    private Date createdDate;

    public Stater() {
    }

    public Stater(Media media, Queue queue, State state) {
        this.media = media;
        this.queue = queue;
        this.state = state;
        this.createdDate = new Date();
    }
}