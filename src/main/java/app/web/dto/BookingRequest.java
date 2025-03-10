package app.web.dto;

import app.room.model.Room;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequest {
    @NotBlank
    @Size(min = 3, max = 50, message = "Please enter your first and family name")
    private String fullName;

    @Email(message = "Email cannot be empty!")
    private String email;

    @NotNull(message = "Please enter arrival date")
    private LocalDate checkInDate;

    @NotNull(message = "Please enter leaving date")
    private LocalDate checkOutDate;

    @NotNull(message = "Please select room")
    private Room room;

}
