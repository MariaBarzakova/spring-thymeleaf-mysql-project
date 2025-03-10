package app.web;

import app.booking.service.BookingService;
import app.room.model.Room;
import app.room.repository.RoomRepository;
import app.room.service.RoomService;
import app.user.model.User;
import app.user.service.UserService;
import app.web.dto.RoomRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;
    private final UserService userService;

    @Autowired
    public RoomController(RoomService roomService, UserService userService) {
        this.roomService = roomService;
        this.userService = userService;
    }

    @GetMapping("/new")
    public ModelAndView registerNewRoom(HttpSession session) {
        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.getUserById(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("rooms");
        modelAndView.addObject("user", user);
        modelAndView.addObject("roomRequest", new RoomRequest());
        return modelAndView;
    }

    //GET /rooms/max-room-number
    @PostMapping("/new")
    public String createRoom(@Valid RoomRequest roomRequest, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "rooms";
        }
        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.getUserById(userId);
        roomService.createNewRoom(roomRequest);
        return "redirect:/home";
    }

    @GetMapping("/{id}")
    public ModelAndView getRoomDetails(@PathVariable UUID id) {
        Room roomDetails = roomService.getRoomById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("room-details");
        modelAndView.addObject("roomDetails", roomDetails);
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public String deleteFromNewRoomById(@PathVariable UUID id) {
        roomService.deleteRoomById(id);
        return "redirect:/home";
    }
}

