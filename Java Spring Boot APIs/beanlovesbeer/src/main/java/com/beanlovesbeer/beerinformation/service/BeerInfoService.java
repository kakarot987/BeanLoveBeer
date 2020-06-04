package com.beanlovesbeer.beerinformation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beanlovesbeer.beerinformation.entity.BeerInfo;
import com.beanlovesbeer.beerinformation.repository.BeerInfoRepository;

@Service
public class BeerInfoService {

	@Autowired
	BeerInfoRepository beerInfoRepository;
	
	public Iterable<BeerInfo> getInfo() {
		return beerInfoRepository.findAll();
	}
	
	
}
