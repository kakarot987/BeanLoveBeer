package com.beanlovesbeer.beerinformation.imageAPI;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
	
	@Autowired
	private ImageRepository imageRepository;
	  
    public ImageModel storeFile(MultipartFile file) throws IOException {
   // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ImageModel dbFile = new ImageModel(fileName, file.getContentType(), file.getBytes());

            return imageRepository.save(dbFile);
    }
    
    public ImageModel getFile(String fileId) {
        return imageRepository.findById(fileId)
               .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
    
    public Iterable<ImageModel> getName() {
    	return imageRepository.findAll();
    }
    
        }