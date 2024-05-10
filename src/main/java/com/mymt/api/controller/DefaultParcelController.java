package com.mymt.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mymt.api.dto.ParcelRequest;
import com.mymt.api.dto.ParcelResponse;
import com.mymt.service.ParcelService;

@RequestMapping("/api/v1/parcel")
@RestController
public class DefaultParcelController implements ParcelController {

    private final ParcelService parcelService;

    public DefaultParcelController(ParcelService service) {
        this.parcelService = service;
    }

    @GetMapping("/")
    public String parcelTest() {
        System.out.println("this is the test of parcel app");
        return "this is the test of parcel app";
    }

    private static String checkVoucher(String code) {

        if (code == null) return null;

        final String validCode = "https://app.swaggerhub.com/apis/mynt-iat/mynt-programming-exams/1.1.0/voucher"+code;

        RestTemplate restTemplate = new RestTemplate();
        String discount = restTemplate.getForObject(validCode, String.class);

        System.out.println("discount::"+discount); //TODO:: get discount

        return discount;
    }

    @Override
    // @PostMapping("/computeDelivery")
    @RequestMapping(value = "/computeDelivery",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public ResponseEntity<?> computeCostDelivery(@Valid @RequestBody ParcelRequest request) {

        ParcelResponse response = parcelService.compute(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
