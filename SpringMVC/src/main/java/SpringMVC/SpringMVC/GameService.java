package SpringMVC.SpringMVC;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameService {

    List<Game> getGamesList();

    List<Game> getGameByTitle(String title);
}
