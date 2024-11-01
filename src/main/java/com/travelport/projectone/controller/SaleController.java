
package com.travelport.projectone.controller;

import com.travelport.projectone.dto.SaleRequest;
import com.travelport.projectone.dto.SaleResponse;
import com.travelport.projectone.service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class SaleController {
    private final SaleService saleService;

    public SaleController(SaleService saleService){this.saleService=saleService;}

    @GetMapping("/{id}")
    public List<SaleResponse> getPastSales(@PathVariable("id") Integer clientId){
        return saleService.findAll(clientId);
    }

    @PostMapping("/sell")
    public String sellProducts(@RequestBody SaleRequest saleRequest){
       /* if(!saleRequest.areProductsQuantityValid()) return null;
        saleService.saveSale(saleRequest);*/
        return "all good";
    }

    @GetMapping("/report/{id}")
    public String incomeReport(@PathVariable("id") Integer productId) {
        /*List<Object[]> report = saleService.incomeReport(productId);
        return ResponseEntity.ok(report);*/
        return "en fase de desarrollo";
    }
}