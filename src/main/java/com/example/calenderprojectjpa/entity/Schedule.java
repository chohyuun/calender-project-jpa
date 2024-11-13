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
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Schedule() {

    }

    // update schedule data
    public void update(String title, String contents) {
        this.title = title == null ? this.title : title;
        this.contents = contents == null ? this.contents : contents;
    }

    public void setUserId(User user) {
        this.id = user.getId();
    }
}
