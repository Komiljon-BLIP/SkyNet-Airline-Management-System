package com.skynet.skynet_backend.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "flights")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String source;

    private String destination;

    private double cost;

    private double distance;

    private int duration;
}