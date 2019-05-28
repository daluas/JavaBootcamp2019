package SpringMVC.SpringMVC;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
class GameServiceImpl implements GameService {

    List<Game> gamesList = new ArrayList<Game>()
    {{
        add(new Game("Dragon Age: Origins",new Date(), 9.4,12));
        add(new Game("Pillars of Eternity",new Date(), 8.9,20));
        add(new Game("Shadownrun: Hong Kong",new Date(), 8.7,23));
        add(new Game("Trine",new Date(), 9.0,10));
        add(new Game("Knights of the old Republic",new Date(), 8.8,5));
    }};

    @Override
    public List<Game> getGamesList(){
        return gamesList;
    }

    @Override
    public List<Game> getGameByTitle(String title){
        return gamesList.stream().filter(g -> title.equals(g.getTitle())).collect(Collectors.toList());
    }
}
