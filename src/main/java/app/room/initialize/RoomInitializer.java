package app.room.initialize;

import app.room.model.Room;
import app.room.model.RoomType;
import app.room.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class RoomInitializer implements CommandLineRunner {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomInitializer(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        roomRepository.save(new Room(UUID.randomUUID(), "001", RoomType.SINGLE, BigDecimal.valueOf(80.00), "Single", "/images/single room 1.png"));
        roomRepository.save(new Room(UUID.randomUUID(), "002", RoomType.SINGLE, BigDecimal.valueOf(80.00), "Single", "/images/single room 2.png"));
        roomRepository.save(new Room(UUID.randomUUID(), "003", RoomType.SINGLE, BigDecimal.valueOf(80.00), "Single", "/images/single room 3.png"));
        roomRepository.save(new Room(UUID.randomUUID(), "004", RoomType.DOUBLE, BigDecimal.valueOf(110.00), "Double", "/images/double room 1.png"));
        roomRepository.save(new Room(UUID.randomUUID(), "005", RoomType.DOUBLE, BigDecimal.valueOf(110.00), "Double", "/images/double room 2.png"));
        roomRepository.save(new Room(UUID.randomUUID(), "006", RoomType.SUITE, BigDecimal.valueOf(140.00), "Suite", "/images/suite 1.png"));
        roomRepository.save(new Room(UUID.randomUUID(), "007", RoomType.SUITE, BigDecimal.valueOf(140.00), "Suite", "/images/suite 2.png"));
    }
}
