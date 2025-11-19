package com.bikeshare.catalog.bike;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class BikeDTOs {

    public record Create(
            @NotNull Long ownerId,
            @NotBlank @Size(max=120) String model,
            @NotNull BikeType type,
            @NotNull @DecimalMin("0.1") BigDecimal costPerMinute,
            String imageUrl,
            @NotNull Double latitude,
            @NotNull Double longitude
    ) {}

    public record Update(
            @Size(max=120) String model,
            BikeType type,
            @DecimalMin("0.1") BigDecimal costPerMinute,
            String imageUrl,
            Double latitude,
            Double longitude,
            BikeStatus status
    ) {}

    public record View(
            Long id,
            String model,
            BikeType type,
            BigDecimal costPerMinute,
            String imageUrl,
            Double latitude,
            Double longitude,
            BikeStatus status,
            Long ownerId
    ) {}

    public static View toView(Bike b) {
        return new View(
                b.getId(),
                b.getModel(),
                b.getType(),
                b.getCostPerMinute(),
                b.getImageUrl(),
                b.getLatitude(),
                b.getLongitude(),
                b.getStatus(),
                b.getOwnerId()
        );
    }
}