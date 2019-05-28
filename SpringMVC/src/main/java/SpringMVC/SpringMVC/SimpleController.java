package SpringMVC.SpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SimpleController {

    @Autowired
    GameService gameServiceImpl;

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameServiceImpl.getGamesList();
        if (!games.isEmpty()) {
            return new ResponseEntity<>(games, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(games, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/games/{title}", method = RequestMethod.GET)
    ResponseEntity<List<Game>> getGameById(@PathVariable  String title) {
        List<Game> game = gameServiceImpl.getGameByTitle(title);
        return new ResponseEntity<>(game, HttpStatus.FOUND);
    }
}
