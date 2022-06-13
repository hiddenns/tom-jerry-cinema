package com.tomjerry.tom.jerry.repository;

import com.tomjerry.tom.jerry.Season;
import com.tomjerry.tom.jerry.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class StreamingRepository{

    private SeasonsRepository seasonsRepository;

    private SeriesRepository seriesRepository;

    @Autowired
    public StreamingRepository(SeasonsRepository seasonsRepository, SeriesRepository seriesRepository) {
        this.seasonsRepository = seasonsRepository;
        this.seriesRepository = seriesRepository;
    }

    //SELECT SEASON.ID, SEASON.NAME, SEASON.NUMBER, SERIES.NAME, SERIES.POS  FROM SERIES  RIGHT JOIN SEASON ON SEASON.ID = SERIES.SEASON_ID
        private final List<Season> allMovies = Arrays.asList(
                new Season("first", 1, Arrays.asList(
                    new Series("01. За что наказали кота", "",1),
                    new Series("02. Поздний ужин","" ,2),
                    new Series("03. Ночь перед Рождеством","" ,3),
                    new Series("04. Кот-трусишка","",4),
                    new Series("05. Пес - нам не товарищ","" ,5),
                    new Series("06. Гости не должны скучать", "",6),
                    new Series("07. Мышонок-стратег","" ,7),
                    new Series("08. К чему приводит жадность","" ,8),
                    new Series("09. Давай сыграем в кегли","" ,9),
                    new Series("10. Пернатая заступница", "",10),
                    new Series("11. Когда мышонку стало скучно", "",11),
                    new Series("12. Нелегко быть младенцем", "",12),
                    new Series("13. Кот-стиляга", "",13),
                    new Series("14. Телохранитель", "",14),
                    new Series("15. В собачьей шкуре", "",15),
                    new Series("16. Неуловимый мышонок", "",16),
                    new Series("17. Романтический ужин", "",17),
                    new Series("18. Мышонок в Нью-Йорке", "",18),
                    new Series("19. Игра в гольф", "",19)))
            /*new Season("second",2, Arrays.asList(
                    new Series("Слава Україні", 1, 2),
                    new Series("Слава Нації", 2, 2),
                    new Series("Смерть ворогам", 3, 2))),
            new Season("third",3, Arrays.asList(
                    new Series("3 season", 1, 3),
                    new Series("3 sea", 2, 3),
                    new Series("3", 3, 3),
                    new Series("season", 4, 3))),
            new Season("four",4, Arrays.asList(
                    new Series("4 season", 1, 4),
                    new Series("4 sea", 2, 4),
                    new Series("4", 3, 4),
                    new Series("4 season", 4, 4)))*/
    );


    public Season getSeason(int season) {
        return allMovies.get(season-1);
    }

    public List<Season> getAllSeasons(){
        return allMovies;
    }

    public List<Season> findAll(){
        Iterable<Season> seasonIterable = seasonsRepository.findAll();
        List<Season> seasonList = new ArrayList<>();
        seasonIterable.forEach((i) -> seasonList.add(i));
        return seasonList;
    }

    public Series findSeriesBySeason(int season, int series) {
        return seriesRepository.findSeriesBySeason(season, series);
    }


}
