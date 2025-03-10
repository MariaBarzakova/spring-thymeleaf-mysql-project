package app.room.model;

import app.booking.model.Booking;
import app.user.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.IMessage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String roomNumber;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private RoomType type;

    @Column(name = "price_per_night")
    private BigDecimal pricePerNight;

    @Column
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

}
