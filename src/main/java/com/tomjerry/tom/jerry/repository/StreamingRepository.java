package com.tomjerry.tom.jerry.repository;

import com.tomjerry.tom.jerry.Season;
import com.tomjerry.tom.jerry.SeriesDto;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class StreamingRepository {

        private final List<Season> allMovies = Arrays.asList(
                new Season("first", 1, Arrays.asList(
                    new SeriesDto("01. За что наказали кота", 1, 1),
                    new SeriesDto("02. Поздний ужин", 2, 1),
                    new SeriesDto("03. Ночь перед Рождеством", 3, 1),
                    new SeriesDto("04. Кот-трусишка", 4, 1),
                    new SeriesDto("05. Пес - нам не товарищ", 5, 1),
                    new SeriesDto("06. Гости не должны скучать", 6, 1),
                    new SeriesDto("07. Мышонок-стратег", 7, 1),
                    new SeriesDto("08. К чему приводит жадность", 8, 1),
                    new SeriesDto("09. Давай сыграем в кегли", 9, 1),
                    new SeriesDto("10. Пернатая заступница", 10, 1),
                    new SeriesDto("11. Когда мышонку стало скучно", 11, 1),
                    new SeriesDto("12. Нелегко быть младенцем", 12, 1),
                    new SeriesDto("13. Кот-стиляга", 13, 1),
                    new SeriesDto("14. Телохранитель", 14, 1),
                    new SeriesDto("15. В собачьей шкуре", 15, 1),
                    new SeriesDto("16. Неуловимый мышонок", 16, 1),
                    new SeriesDto("17. Романтический ужин", 17, 1),
                    new SeriesDto("18. Мышонок в Нью-Йорке", 18, 1),
                    new SeriesDto("19. Игра в гольф", 19, 1))),
            new Season("second",2, Arrays.asList(
                    new SeriesDto("Слава Україні", 1, 2),
                    new SeriesDto("Слава Нації", 2, 2),
                    new SeriesDto("Смерть ворогам", 3, 2))),
            new Season("third",3, Arrays.asList(
                    new SeriesDto("3 season", 1, 3),
                    new SeriesDto("3 sea", 2, 3),
                    new SeriesDto("3", 3, 3),
                    new SeriesDto("season", 4, 3))),
            new Season("four",4, Arrays.asList(
                    new SeriesDto("4 season", 1, 4),
                    new SeriesDto("4 sea", 2, 4),
                    new SeriesDto("4", 3, 4),
                    new SeriesDto("4 season", 4, 4)))
    );


    public Season getSeason(int season) {
        return allMovies.get(season-1);
    }

    public List<Season> getAllSeasons(){
        return allMovies;
    }

    public SeriesDto findSeriesBySeason(int season, int series) {
        return allMovies.get(season-1).getSeriesList().get(series-1);
    }


}
