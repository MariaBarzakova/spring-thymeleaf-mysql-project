package app.web.dto;

import app.room.model.RoomType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class RoomRequest {
    @NotBlank
    private String roomNumber;

    @NotBlank
    private RoomType type;

    @NotNull
    private BigDecimal pricePerNight;

    @NotBlank
    private String description;

    @NotBlank
    private String imageUrl;
}
