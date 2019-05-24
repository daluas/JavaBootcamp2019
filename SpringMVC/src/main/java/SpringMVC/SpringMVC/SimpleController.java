package SpringMVC.SpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.ws.Response;
import java.util.List;

@Controller
public class SimpleController {

    GameService gameService = new GameService();

    @RequestMapping(value="/games", method=RequestMethod.GET)
    ResponseEntity<List<Game>> getAllGames(){
        List<Game> games = gameService.getGameList();
        if(!games.isEmpty()){
            return new ResponseEntity<>(games,HttpStatus.FOUND);
        }
        else
        {
            return new ResponseEntity<>(games,HttpStatus.NOT_FOUND);
        }
    }
   @RequestMapping(value="/games/{title}", method=RequestMethod.POST)
    ResponseEntity<Game> getGameById( String title){
        Game game = gameService.getGameByTitle(title);
       if(!game.equals(null)){
           return new ResponseEntity<>(game,HttpStatus.FOUND);
       }
       else
       {
           return new ResponseEntity<>(game,HttpStatus.NOT_FOUND);
       }
    }
}
