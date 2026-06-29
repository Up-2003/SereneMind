package com.mental.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "meditations")
@Getter
@Setter
public class Meditation extends BaseEntity {

    private String title;
    private String category;
    private int duration;
    private String audioUrl;
}