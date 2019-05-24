package SpringMVC.SpringMVC;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameService {

    List<Game> gamesList = new ArrayList<Game>()
    {{
        add(new Game("Dragon Age: Origins",new Date(), 9.4,12));
        add(new Game("Pillars of Eternity",new Date(), 8.9,20));
        add(new Game("Shadownrun: Hong Kong",new Date(), 8.7,23));
        add(new Game("Trine",new Date(), 9.0,10));
        add(new Game("Knights of the old Republic",new Date(), 8.8,5));
    }};

    @Bean
    List<Game> getGameList(){
        return gamesList;
    }

    @Bean
    Game getGameByTitle(String title){
        Optional<Game> reduce = gamesList.stream().filter(x -> x.getTitle().equals(title)).reduce((a, b) -> null);
        return reduce.get();
    }
}
