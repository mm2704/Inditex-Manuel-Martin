package com.inditex.manuelMartin.service;

import com.inditex.manuelMartin.dto.PriceDTO;
import com.inditex.manuelMartin.model.Price;
import com.inditex.manuelMartin.repository.PriceRepository;
import com.inditex.manuelMartin.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceService {

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    private PriceRepository priceRepository;

    public PriceDTO getProductPrice(String date, Integer idBrand, Integer idProduct) {
        LocalDateTime localDateTime = dateUtils.getLocalDateTime(date);
        //TODO repository.method(...);
        return null;
    }
}
