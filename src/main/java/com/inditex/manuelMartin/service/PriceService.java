package com.inditex.manuelMartin.service;

import com.inditex.manuelMartin.dto.PriceDTO;
import com.inditex.manuelMartin.exception.ApiRequestException;
import com.inditex.manuelMartin.mapper.PriceResponseMapper;
import com.inditex.manuelMartin.model.Price;
import com.inditex.manuelMartin.repository.PriceRepository;
import com.inditex.manuelMartin.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceService {

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private PriceResponseMapper priceResponseMapper;

    @Autowired
    private Environment env;

    public PriceDTO getProductPrice(String date, Integer idBrand, Integer idProduct) {
        LocalDateTime localDateTime = dateUtils.getLocalDateTime(date);
        Price price = priceRepository.findByStartDateBeforeAndEndDateAfter(localDateTime, idBrand, idProduct);
        if (price == null) {
            throw new ApiRequestException(env.getProperty("product.not.found"));
        } else {
            return priceResponseMapper.mapFrom(price);
        }
    }
}
