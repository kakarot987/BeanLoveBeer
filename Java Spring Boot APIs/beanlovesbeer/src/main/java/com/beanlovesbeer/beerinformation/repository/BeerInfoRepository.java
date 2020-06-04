package com.beanlovesbeer.beerinformation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beanlovesbeer.beerinformation.entity.BeerInfo;

@Repository
public interface BeerInfoRepository extends CrudRepository<BeerInfo, String>{

}
