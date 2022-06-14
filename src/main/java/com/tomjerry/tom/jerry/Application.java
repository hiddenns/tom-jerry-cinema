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

				seriesRepo.save(new Series("01. За что наказали кота", "", 1, 1));
				seriesRepo.save(new Series("02. Поздний ужин", "",2, 1));
				seriesRepo.save(new Series("03. Ночь перед Рождеством", "",3, 1));
				seriesRepo.save(new Series("04. Кот-трусишка", "", 4, 1));
				seriesRepo.save(new Series("05. Пес - нам не товарищ", "",5, 1));
				seriesRepo.save(new Series("06. Гости не должны скучать", "",6, 1));
				seriesRepo.save(new Series("07. Мышонок-стратег", "",7, 1));
				seriesRepo.save(new Series("08. К чему приводит жадность", "",8, 1));
				seriesRepo.save(new Series("09. Давай сыграем в кегли", "",9, 1));
				seriesRepo.save(new Series("10. Пернатая заступница", "",10, 1));
				seriesRepo.save(new Series("11. Когда мышонку стало скучно", "",11, 1));
				seriesRepo.save(new Series("12. Нелегко быть младенцем","",12, 1));
				seriesRepo.save(new Series("13. Кот-стиляга", "",13, 1));
				seriesRepo.save(new Series("14. Телохранитель", "",14, 1));
				seriesRepo.save(new Series("15. В собачьей шкуре", "",15, 1));
				seriesRepo.save(new Series("16. Неуловимый мышонок", "",16, 1));
				seriesRepo.save(new Series("17. Романтический ужин", "",17, 1));
				seriesRepo.save(new Series("18. Мышонок в Нью-Йорке", "",18, 1));
				seriesRepo.save(new Series("19. Игра в гольф", "",19, 1));
				seriesRepo.save(new Series("Слава Україні","", 1, 2));
				seriesRepo.save(new Series("Слава Нації", "",2, 2));
				seriesRepo.save(new Series("Смерть ворогам", "", 3, 2));
				seriesRepo.save(new Series("3 season", "",1, 3));
				seriesRepo.save(new Series("3 sea", "", 2, 3));
				seriesRepo.save(new Series("3", "", 3, 3));
				seriesRepo.save(new Series("season", "",4, 3));
			}
		};
	}

}
