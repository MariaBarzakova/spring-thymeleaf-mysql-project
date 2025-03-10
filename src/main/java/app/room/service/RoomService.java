package app.room.service;

import app.exception.DomainException;
import app.room.model.Room;
import app.room.model.RoomType;
import app.room.repository.RoomRepository;
import app.web.dto.RoomRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void createNewRoom(RoomRequest roomRequest) {
        RoomType typeOfRoom = roomRequest.getType();
        Room room = Room.builder()
                .roomNumber(roomRequest.getRoomNumber())
                .type(typeOfRoom)
                .pricePerNight(roomRequest.getPricePerNight())
                .description(roomRequest.getDescription())
                .imageUrl(roomRequest.getImageUrl())
                .build();
        roomRepository.save(room);
        log.info("Successfully created new room");
    }

    public Room getRoomById(UUID roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new DomainException("Room with id %s does not exist.".formatted(roomId)));
    }

    public void deleteRoomById(UUID id) {
        roomRepository.deleteById(id);
    }

    public List<Room> getAllRooms(){
        List<Room> allRooms = roomRepository.findAll();
        allRooms.sort(Comparator.comparing(Room::getType));
        return allRooms;
    }

}
