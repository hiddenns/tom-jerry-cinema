package com.tomjerry.tom.jerry;

import com.tomjerry.tom.jerry.repository.SeasonsRepository;
import com.tomjerry.tom.jerry.repository.SeriesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(SeasonsRepository cinemaRepo, SeriesRepository seriesRepo){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				cinemaRepo.save(new Season("first", 1));
				cinemaRepo.save(new Season("second", 2));
				cinemaRepo.save(new Season("third", 3));
				cinemaRepo.save(new Season("fourth", 4));

				seriesRepo.save(new Series("season1series1","01. За что наказали кота", 1, 1));
				seriesRepo.save(new Series("season1series2", "02. Поздний ужин",2, 1));
				seriesRepo.save(new Series("season1series3", "03. Ночь перед Рождеством",3, 1));
				seriesRepo.save(new Series("season1series4", "04. Кот-трусишка", 4, 1));
				seriesRepo.save(new Series("season1series5", "05. Пес - нам не товарищ",5, 1));
				seriesRepo.save(new Series("season1series6", "06. Гости не должны скучать",6, 1));
				seriesRepo.save(new Series("season1series7", "07. Мышонок-стратег",7, 1));
				seriesRepo.save(new Series("season1series8", "08. К чему приводит жадность",8, 1));
				seriesRepo.save(new Series("season1series9", "09. Давай сыграем в кегли",9, 1));
				seriesRepo.save(new Series("season1series10", "10. Пернатая заступница",10, 1));
				seriesRepo.save(new Series("season1series11", "11. Когда мышонку стало скучно",11, 1));
				seriesRepo.save(new Series("season1series12", "12. Нелегко быть младенцем",12, 1));
				seriesRepo.save(new Series("season1series13", "13. Кот-стиляга",13, 1));
				seriesRepo.save(new Series("season1series14", "14. Телохранитель",14, 1));
				seriesRepo.save(new Series("season1series15", "15. В собачьей шкуре",15, 1));
				seriesRepo.save(new Series("season1series16", "16. Неуловимый мышонок",16, 1));
				seriesRepo.save(new Series("season1series17", "17. Романтический ужин",17, 1));
				seriesRepo.save(new Series("season1series18", "18. Мышонок в Нью-Йорке",18, 1));
				seriesRepo.save(new Series("season1series19", "19. Игра в гольф",19, 1));

				seriesRepo.save(new Series("season2series1", "01. Птичке хочется любви", 1, 2));
				seriesRepo.save(new Series("season2series2", "02. Соблюдайте тишину",2, 2));
				seriesRepo.save(new Series("season2series3", "03. Пришла весна", 3, 2));
				seriesRepo.save(new Series("season2series3", "04. Подкидыш", 4, 2));
				seriesRepo.save(new Series("season2series3", "05. Охота на мышей", 5, 2));
				seriesRepo.save(new Series("season2series3", "06. Шумная серенада", 6, 2));
				seriesRepo.save(new Series("season2series3", "07. Том и Джерри на рыбалке", 7, 2));
				seriesRepo.save(new Series("season2series3", "08. Перемирие", 8, 2));
				seriesRepo.save(new Series("season2series3", "09. Концерт для кота с оркестром!", 9, 2));
				seriesRepo.save(new Series("season2series3", "10. Доктор Джекел и мистер Мыш", 10, 2));

				seriesRepo.save(new Series("season3series1", "01. Оставьте в покое свои неприятности",1, 3));
				seriesRepo.save(new Series("season3series2", "02. Райский кот", 2, 3));
				seriesRepo.save(new Series("season3series3", "03. Кот и мышь-русалка", 3, 3));
				seriesRepo.save(new Series("season3series4", "04. Люби этого щенка",4, 3));
				seriesRepo.save(new Series("season3series5", "05. Дневник Джерри",5, 3));
				seriesRepo.save(new Series("season3series6", "06. Игроки в теннис",6, 3));
				seriesRepo.save(new Series("season3series7", "07. Маленький утёнок",7, 3));
				seriesRepo.save(new Series("season3series8", "08. Кошачья вечеринка",8, 3));
				seriesRepo.save(new Series("season3series9", "09. Том-техасец",9, 3));

				seriesRepo.save(new Series("season4series1", "01. Кошачий тихий час", 1,4));
				seriesRepo.save(new Series("season4series2", "02. Летающий кот", 2,4));
				seriesRepo.save(new Series("season4series3", "03. Кошачий доктор", 3,4));
				seriesRepo.save(new Series("season4series4", "04. Два мушкетёра", 4,4));
			}
		};
	}

}
