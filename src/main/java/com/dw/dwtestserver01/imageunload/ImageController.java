package com.dw.dwtestserver01.imageunload;

import com.dw.dwtestserver01.common.dto.SingleResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/image")
public class ImageController {

    private final ImageService imageService;
    public ImageController(ImageService imageService){
        this.imageService = imageService;
    }


    @PostMapping
    public ResponseEntity uploadUrl(){
        Mono<Object> getImageUrl = imageService.getUploadUrl();
        return new ResponseEntity<>(
                new SingleResponseDto<>(getImageUrl.block()),
                HttpStatus.CREATED
        );
    }
}
