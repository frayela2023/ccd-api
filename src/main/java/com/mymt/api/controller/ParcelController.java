package com.mymt.api.controller;

import org.springframework.http.ResponseEntity;

import com.mymt.api.dto.ParcelRequest;

public interface ParcelController {

    ResponseEntity<?> computeCostDelivery(ParcelRequest request);
}