package app.web;

import app.room.model.Room;
import app.room.service.RoomService;
import app.user.model.User;
import app.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class HomeController {
    private final UserService userService;
    private final RoomService roomService;

    @Autowired
    public HomeController(UserService userService, RoomService roomService) {
        this.userService = userService;
        this.roomService = roomService;
    }

    @GetMapping("/home")
    public ModelAndView getHomePage(HttpSession session) {
        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.getUserById(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
    @GetMapping("/rooms")
    public ModelAndView getRoomsPage(HttpSession session) {
        UUID userId = (UUID) session.getAttribute("user_id");
        User user = userService.getUserById(userId);
        List<Room> allRooms = roomService.getAllRooms();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("rooms");
        modelAndView.addObject("user", user);
        modelAndView.addObject("allRooms", allRooms);
        return modelAndView;
    }

}
