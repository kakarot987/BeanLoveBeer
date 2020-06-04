package com.beanlovesbeer.beerinformation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beanlovesbeer.beerinformation.repository.BeerInfoRepository;
import com.beanlovesbeer.beerinformation.repository.FavroiteBeerRepository;
import com.beanlovesbeer.beerinformation.service.BeerInfoService;

import com.beanlovesbeer.beerinformation.entity.BeerInfo;
import com.beanlovesbeer.beerinformation.entity.BodyModal;
import com.beanlovesbeer.beerinformation.entity.FavroiteBeer;
import com.beanlovesbeer.beerinformation.entity.FavroiteBeerModal;
import com.beanlovesbeer.beerinformation.imageAPI.ImageModel;
import com.beanlovesbeer.beerinformation.imageAPI.ImageRepository;
import com.beanlovesbeer.beerinformation.imageAPI.ImageService;
import com.beanlovesbeer.beerinformation.imageAPI.UploadImageResponse;

import org.springframework.http.ResponseEntity;


@CrossOrigin(origins = "http://localhost:4200", maxAge=36000)
@Controller
@RequestMapping(path = "/beerinfo")
public class BeerController {
	
	private static final Logger Logger = LoggerFactory.getLogger(BeerController.class);

	@Autowired
	private BeerInfoService beerInfoService;
	
	@Autowired
	private BeerInfoRepository beerInfoRepository;

	@Autowired
	private ImageService imageService;
	
	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private FavroiteBeerRepository favroiteBeerRepository;
				
	@PostMapping("/adddetails")
	public @ResponseBody BeerInfo addNewBeerDetails(@RequestBody BodyModal bodyModal){
		BeerInfo beerInfo = new BeerInfo();
      	beerInfo.setId(bodyModal.id);
		beerInfo.setName(bodyModal.name);
		beerInfo.setInvented(bodyModal.invented);
		beerInfo.setAlcohol(bodyModal.alcohol);
		beerInfo.setManufacturer(bodyModal.manufacturer);
		beerInfo.setDescription(bodyModal.description);
		beerInfoRepository.save(beerInfo);
		return new BeerInfo();
	}
	
	@PostMapping("/addFavroite")
	public @ResponseBody FavroiteBeer addFavroite(@RequestBody FavroiteBeerModal fav) {
		FavroiteBeer favBeer = new FavroiteBeer();
		favBeer.setId(fav.id);
		favroiteBeerRepository.save(favBeer);
		return new FavroiteBeer();
	}
	
	@GetMapping("/getFavrote")
	public @ResponseBody Iterable<FavroiteBeer> getfav(){
		return favroiteBeerRepository.findAll();
		
	}
	
	 @GetMapping(path="/beerinfo")
	 public @ResponseBody Iterable<BeerInfo> getallDetails(){
		 return beerInfoService.getInfo();
	 }
	 
	@GetMapping(path="/beerName")
	public @ResponseBody Iterable<ImageModel> getName(){
		return imageService.getName();
	}
	 
	 @PostMapping("/uploadFile")
	    public UploadImageResponse uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
	        ImageModel dbFile = imageService.storeFile(file);

	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(dbFile.getId())
	                .toUriString();

	        return new UploadImageResponse(dbFile.getFileName(), fileDownloadUri,
	                file.getContentType(), file.getSize());
	    }
	 
	 @GetMapping("/downloadFile/{fileId}")
	    public ResponseEntity<Resource> downloadFile(@org.springframework.web.bind.annotation.PathVariable String fileId) {
	        // Load file from database
		 ImageModel dbFile = imageService.getFile(fileId);

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
	                .body(new ByteArrayResource(dbFile.getData()));
	    }

	 
	 /*
	 @GetMapping(path="/getImage")
	 public @ResponseBody Iterable<UploadImageResponse> getImage(){
		 return responseRepository.findAll();
	 }
	 */
}