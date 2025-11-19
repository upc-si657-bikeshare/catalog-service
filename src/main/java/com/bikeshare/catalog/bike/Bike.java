package com.bikeshare.catalog.bike;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity @Table(name = "bikes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Bike {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "owner_id", nullable = false)
    private Long ownerId;

    @Column(nullable = false, length = 120)
    private String model;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 32)
    private BikeType type;

    @Column(name = "cost_per_minute", nullable = false, precision = 10, scale = 2)
    private BigDecimal costPerMinute;

    private String imageUrl;
    private Double latitude;
    private Double longitude;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 24)
    @Builder.Default
    private BikeStatus status = BikeStatus.AVAILABLE;
}