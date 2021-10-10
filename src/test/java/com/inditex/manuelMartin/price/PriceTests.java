package com.inditex.manuelMartin.price;


import com.inditex.manuelMartin.dto.PriceDTO;
import com.inditex.manuelMartin.exception.ApiRequestException;
import com.inditex.manuelMartin.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class PriceTests {

    @Autowired
    PriceService priceService;

    @Autowired
    Environment env;


    @Test
    public void whenDateIs14At10AmThenReturnPriceList1() {
        PriceDTO priceDTO = priceService.getProductPrice("2020-06-14 10:00:00", 1, 35455);
        assertEquals(1, priceDTO.getPriceList());
        assertEquals(35.5, priceDTO.getPrice());
        assertEquals(35455, priceDTO.getProductId());
        assertEquals(1, priceDTO.getBrandId());
    }

    @Test
    public void whenDateIs14At16PmThenReturnPriceList2() {
        PriceDTO priceDTO = priceService.getProductPrice("2020-06-14 16:00:00", 1, 35455);
        assertEquals(2, priceDTO.getPriceList());
        assertEquals(25.45, priceDTO.getPrice());
        assertEquals(35455, priceDTO.getProductId());
        assertEquals(1, priceDTO.getBrandId());
    }

    @Test
    public void whenDateIs14At21PmThenReturnPriceList1() {
        PriceDTO priceDTO = priceService.getProductPrice("2020-06-14 21:00:00", 1, 35455);
        assertEquals(1, priceDTO.getPriceList());
        assertEquals(35.5, priceDTO.getPrice());
        assertEquals(35455, priceDTO.getProductId());
        assertEquals(1, priceDTO.getBrandId());
    }

    @Test
    public void whenDateIs15At10AmThenReturnPriceList3() {
        PriceDTO priceDTO = priceService.getProductPrice("2020-06-15 10:00:00", 1, 35455);
        assertEquals(3, priceDTO.getPriceList());
        assertEquals(30.5, priceDTO.getPrice());
        assertEquals(35455, priceDTO.getProductId());
        assertEquals(1, priceDTO.getBrandId());
    }

    @Test
    public void whenDateIs16At21PmThenReturnPriceList4() {
        PriceDTO priceDTO = priceService.getProductPrice("2020-06-16 21:00:00", 1, 35455);
        assertEquals(4, priceDTO.getPriceList());
        assertEquals(38.95, priceDTO.getPrice());
        assertEquals(35455, priceDTO.getProductId());
        assertEquals(1, priceDTO.getBrandId());
    }

    @Test
    public void whenDateIsOutOfRangeThenReturnError() {
        Exception exception = assertThrows(ApiRequestException.class, () -> {
                    priceService.getProductPrice("2021-08-16 21:00:00", 1, 35455);
                });
            String expectedMessage = env.getProperty("product.not.found");
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenDatebadFormattedThenReturnError() {
        Exception exception = assertThrows(ApiRequestException.class, () -> {
            priceService.getProductPrice("2021/08/16 21:00", 1, 35455);
        });
        String expectedMessage = env.getProperty("date.format.error");
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
