
package com.travelport.projectone.controller;

import com.travelport.projectone.dto.ReportResponse;
import com.travelport.projectone.dto.SaleRequest;
import com.travelport.projectone.dto.SaleResponse;
import com.travelport.projectone.entities.Sale;
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
    public ResponseEntity<Sale> sellProducts(@RequestBody SaleRequest saleRequest) {
        return ResponseEntity.ok(saleService.saveSale(saleRequest));
    }

    @GetMapping("/report")
    public ResponseEntity<List<ReportResponse>> incomeReport() {
        List<ReportResponse> reportResponses = saleService.getIncomeReport();
        return ResponseEntity.ok(reportResponses);
    }
}