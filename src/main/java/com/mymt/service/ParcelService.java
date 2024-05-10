package com.mymt.service;

import com.mymt.api.dto.ParcelRequest;
import com.mymt.api.dto.ParcelResponse;
// import com.mymt.model.Parcel;

public interface ParcelService {

    //Parcel computeDelivery(Parcel parcel);
    ParcelResponse compute(ParcelRequest request);
    
}