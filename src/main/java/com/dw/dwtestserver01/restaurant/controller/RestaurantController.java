package com.dw.dwtestserver01.restaurant.controller;

import com.dw.dwtestserver01.common.dto.SingleResponseDto;
import com.dw.dwtestserver01.restaurant.dto.RestaurantDto;
import com.dw.dwtestserver01.restaurant.entity.RestaurantEntity;
import com.dw.dwtestserver01.restaurant.mapper.RestaurantMapper;
import com.dw.dwtestserver01.restaurant.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;

    public RestaurantController(RestaurantService restaurantService,
                                RestaurantMapper restaurantMapper) {
        this.restaurantService = restaurantService;
        this.restaurantMapper = restaurantMapper;
    }

    @PostMapping
    public ResponseEntity postRestau(@Valid @RequestBody RestaurantDto.Post restauPostDto) {
        RestaurantEntity restau = restaurantService.createRestau(restauPostDto);
        RestaurantDto.Response response = restaurantMapper.restauToRestauResponse(restau);
        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity getAllRestau(RestaurantDto.Get getRestau){
        List<RestaurantEntity> restau = restaurantService.getAllRestau(getRestau);
        return new ResponseEntity<>(
                new SingleResponseDto<>(restaurantMapper.getAllOfRestau(restau)),
                HttpStatus.OK
        );
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity getRestau(@PathVariable("restaurantId") Long restaurantId) {
        return new ResponseEntity<>(
                new SingleResponseDto<>(restaurantService.findRestauByRestauId(restaurantId)),
                HttpStatus.OK
        );
    }

    @PatchMapping
    public ResponseEntity patchRestau(@RequestBody RestaurantDto.Patch restauPatchDto){
        RestaurantEntity result = restaurantService.updateRestau(restauPatchDto);
        return new ResponseEntity<>(
                new SingleResponseDto<>(result),
                HttpStatus.ACCEPTED
        );
    }
}
