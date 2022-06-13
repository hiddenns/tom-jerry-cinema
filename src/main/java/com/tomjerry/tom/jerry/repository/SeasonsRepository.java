package com.tomjerry.tom.jerry.repository;

import com.tomjerry.tom.jerry.Season;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SeasonsRepository extends CrudRepository<Season, Long> {

    @Override
    Optional<Season> findById(Long aLong);
}
