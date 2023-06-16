package com.dw.dwtestserver01.restaurant.mapper;


import com.dw.dwtestserver01.restaurant.dto.RestaurantDto;
import com.dw.dwtestserver01.restaurant.entity.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.util.List;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

    RestaurantEntity restauPostToRestau(RestaurantDto.Post restauPostDto);

    RestaurantDto.Response restauToRestauResponse(RestaurantEntity restau);

    List<RestaurantDto.Get> getAllOfRestau(List<RestaurantEntity> getRestau);

    RestaurantDto.Get getRestauByrestauId(RestaurantEntity restaurantId);

    RestaurantEntity restauPatchToRestau(RestaurantDto.Patch restauPatchDto);
}
