package com.tomjerry.tom.jerry;

import com.tomjerry.tom.jerry.repository.SeasonsRepository;
import com.tomjerry.tom.jerry.repository.SeriesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

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

				seriesRepo.save(new Series("season1series1","01. За что наказали кота", "", 1, 1));
				seriesRepo.save(new Series("season1series2", "02. Поздний ужин", "",2, 1));
				seriesRepo.save(new Series("season1series3", "03. Ночь перед Рождеством", "",3, 1));
				seriesRepo.save(new Series("season1series4", "04. Кот-трусишка", "", 4, 1));
				seriesRepo.save(new Series("season1series5", "05. Пес - нам не товарищ", "",5, 1));
				seriesRepo.save(new Series("season1series6", "06. Гости не должны скучать", "",6, 1));
				seriesRepo.save(new Series("season1series7", "07. Мышонок-стратег", "",7, 1));
				seriesRepo.save(new Series("season1series8", "08. К чему приводит жадность", "",8, 1));
				seriesRepo.save(new Series("season1series9", "09. Давай сыграем в кегли", "",9, 1));
				seriesRepo.save(new Series("season1series10", "10. Пернатая заступница", "",10, 1));
				seriesRepo.save(new Series("season1series11", "11. Когда мышонку стало скучно", "",11, 1));
				seriesRepo.save(new Series("season1series12", "12. Нелегко быть младенцем","",12, 1));
				seriesRepo.save(new Series("season1series13", "13. Кот-стиляга", "",13, 1));
				seriesRepo.save(new Series("season1series14", "14. Телохранитель", "",14, 1));
				seriesRepo.save(new Series("season1series15", "15. В собачьей шкуре", "",15, 1));
				seriesRepo.save(new Series("season1series16", "16. Неуловимый мышонок", "",16, 1));
				seriesRepo.save(new Series("season1series17", "17. Романтический ужин", "",17, 1));
				seriesRepo.save(new Series("season1series18", "18. Мышонок в Нью-Йорке", "",18, 1));
				seriesRepo.save(new Series("season1series19", "19. Игра в гольф", "",19, 1));
				seriesRepo.save(new Series("season2series1", "Слава Україні","", 1, 2));
				seriesRepo.save(new Series("season2series2", "Слава Нації", "",2, 2));
				seriesRepo.save(new Series("season2series3", "Смерть ворогам", "", 3, 2));
				seriesRepo.save(new Series("season3series1", "3 season", "",1, 3));
				seriesRepo.save(new Series("season3series2", "3 sea", "", 2, 3));
				seriesRepo.save(new Series("season3series3", "3", "", 3, 3));
				seriesRepo.save(new Series("season3series4", "season", "",4, 3));
			}
		};
	}

}
