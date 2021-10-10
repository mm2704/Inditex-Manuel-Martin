package com.inditex.manuelMartin.mapper;

import com.inditex.manuelMartin.dto.PriceDTO;
import com.inditex.manuelMartin.model.Price;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PriceResponseMapper {

    PriceDTO mapFrom(Price price);
}
