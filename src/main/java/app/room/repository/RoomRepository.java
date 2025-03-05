package app.room.repository;

import app.room.model.Room;
import app.room.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface RoomRepository extends JpaRepository<Room, UUID> {

}
