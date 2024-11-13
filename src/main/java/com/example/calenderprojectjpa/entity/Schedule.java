package com.example.calenderprojectjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="schedule")
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    public Schedule(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }

    public Schedule() {

    }

    // update schedule data
    public void update(String username, String title, String contents) {
        this.username = username == null ? this.username : username;
        this.title = title == null ? this.title : title;
        this.contents = contents == null ? this.contents : contents;
    }
}
