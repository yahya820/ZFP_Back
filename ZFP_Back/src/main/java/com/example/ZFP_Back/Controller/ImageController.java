package com.example.ZFP_Back.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.ZFP_Back.Dto.PaymentDTO;
import com.example.ZFP_Back.Model.Image;
import com.example.ZFP_Back.Repository.ImageRepository;
import com.example.ZFP_Back.Response.ImageResponse;
import com.example.ZFP_Back.Services.ImageService;

import jakarta.transaction.Transactional;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/images")
public class ImageController {
    @Autowired
    private ImageRepository imageRepository;
    // @Autowired
    public ImageService imageService;

    @PostMapping(value = "/upload/{userId}",consumes = "multipart/form-data")
        @Transactional
        public ResponseEntity<String> uploadImage(@RequestParam("imageFile") MultipartFile file,@PathVariable Long userId) throws IOException {
            Image img = new Image();
            img.setUserId(userId);
            img.setImage_name(file.getOriginalFilename());
            img.setImage(imageService.compressBytes(file.getBytes()));
            imageRepository.save(img);
            return ResponseEntity.status(HttpStatus.OK).body("Image uploaded successfully");
        }

          @GetMapping(path = {"/get/image/info/{booking_id}"})
        public ImageResponse getPaymentDetails(@PathVariable("booking_id") Integer booking_id) throws IOException {
            final Optional<Image> dbImage = imageRepository.getImageyUserId(booking_id);
            ImageResponse dto = new ImageResponse();
            dto.setUser_id(dbImage.get().getUserId());
            dto.setImage_name(dbImage.get().getImage_name());
            dto.setImage(imageService.decompressBytes(dbImage.get().getImage()));
            return dto;
        }
    
    // @PostMapping(value ="upload")
    // public ResponseEntity uploadImage(@RequestParam MultipartFile     file){
    //     return this.imageService.uploadToLocalFileSystem(file);
    // }
    // @GetMapping(
    //         value = "getImage/{imageName:.+}",
    //         produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_PNG_VALUE}
    // )
    // public @ResponseBody byte[] getImageWithMediaType(@PathVariable(name = "imageName") String fileName) throws IOException {
    //     return this.imageService.getImageWithMediaType(fileName);
    // }
}
