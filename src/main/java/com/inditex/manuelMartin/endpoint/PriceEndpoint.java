package com.inditex.manuelMartin.endpoint;

import com.inditex.manuelMartin.dto.PriceDTO;
import com.inditex.manuelMartin.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class PriceEndpoint {

    @Autowired
    private PriceService priceService;


    @GetMapping("/brand/{idBrand}/product/{idProduct}")
    public PriceDTO getProductPrice(@RequestParam(value = "date", required = false) String date,
                                    @PathVariable("idBrand") Integer idBrand,
                                    @PathVariable("idProduct") Integer idProduct) {
        return priceService.getProductPrice(date, idBrand, idProduct);
    }


}
