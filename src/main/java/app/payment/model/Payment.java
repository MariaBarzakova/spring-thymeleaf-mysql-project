package app.payment.model;

import app.booking.model.Booking;
import app.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String transactionId;

    @Column
    private BigDecimal amount;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(nullable = false,name = "payment_method")
    @Enumerated(value = EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(name = "booking_reference")
    private String bookingReference;

    @Column(name = "failure_reason")
    private String failureReason;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
