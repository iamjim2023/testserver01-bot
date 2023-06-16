package com.dw.dwtestserver01.restaurant.service;

import com.dw.dwtestserver01.common.exception.BusinessLogicException;
import com.dw.dwtestserver01.common.exception.ExceptionCode;
import com.dw.dwtestserver01.restaurant.dto.RestaurantDto;
import com.dw.dwtestserver01.restaurant.entity.RestaurantEntity;
import com.dw.dwtestserver01.restaurant.mapper.RestaurantMapper;
import com.dw.dwtestserver01.restaurant.repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    private final RestaurantMapper restaurantMapper;

    public RestaurantService(RestaurantRepository restaurantRepository,
                             RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }


    public RestaurantEntity createRestau(RestaurantDto.Post restauPostDto) {
        RestaurantEntity savedrestau = restaurantRepository.save(
        restaurantMapper.restauPostToRestau(restauPostDto));
        return savedrestau;
    }

    public List<RestaurantEntity> getAllRestau(RestaurantDto.Get getRestau){
        return restaurantRepository.findAll();
    }

    @Transactional(readOnly = true)
    public RestaurantEntity findRestauByRestauId(Long restaurantId) {
        Optional<RestaurantEntity> optionalRestau = restaurantRepository.findById(restaurantId);
        return optionalRestau.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }

    public RestaurantEntity updateRestau(RestaurantDto.Patch restauPatchDto){
        RestaurantEntity updateRestau = restaurantMapper.restauPatchToRestau(restauPatchDto);
        RestaurantEntity updatedRestau = restaurantRepository.save(updateRestau);
        return updatedRestau;
    }
}
