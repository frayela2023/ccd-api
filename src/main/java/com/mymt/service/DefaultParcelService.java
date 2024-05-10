package com.mymt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymt.ParcelCostConfig;
import com.mymt.api.dto.ParcelRequest;
import com.mymt.api.dto.ParcelResponse;
import com.mymt.model.Parcel;

@Service
public class DefaultParcelService implements ParcelService {

    @Autowired
    private ParcelCostConfig costConfig;

    /*@Override   
    public Parcel computeDelivery(Parcel parcel) {

        final double maxWeight = costConfig.getParcelExceeds();
        final double heavyWeight = costConfig.getParcelHeavy();

        final double weight = parcel.getWeight();

        if (weight < maxWeight) { // parcel is less than max weight
            final double heavyCost = costConfig.getHeavyCost();
            parcel.setCost(weight * heavyCost);
            System.out.println("----cost::::"+parcel.getCost());
        } else if (weight < heavyWeight) { // parcel is less than heavy weight
            final double height = parcel.getHeight();
            final double width = parcel.getWidth();
            final double length = parcel.getLength();
            
            final double volume = height * width * length;

            if (volume < 1500) {
                parcel.setCost(volume * 0.03);
            } else if (volume < 2500) {
                parcel.setCost(volume * 0.04);
            } else {
                parcel.setCost(volume * 0.05);
            }
        }

        return parcel;
    }*/

    public ParcelResponse compute(ParcelRequest request) {

        Parcel parcel = Parcel.builder()
           .weight(request.getWeight())
           .height(request.getHeight())
           .width(request.getWidth())
           .length(request.getLength())
           .voucher(request.getVoucher())
           .build();

        ParcelResponse response = new ParcelResponse(parcel);

        final double maxWeight = costConfig.getParcelExceeds();
        final double heavyWeight = costConfig.getParcelHeavy();

        final double weight = parcel.getWeight();

        if (weight > maxWeight) { // over weight
            response.setPriority((byte) 1);
            response.setStatus("Reject"); // Rule name
            response.setCondition("Weight exceeds 50kg");
            response.setDeliveryCost(0);
        } else {
            System.out.println("weight::"+weight+" heavyWeight::"+heavyWeight);
            if (weight > heavyWeight) { // heavy weight
                response.setPriority((byte) 2);
                response.setStatus("Heavy Parcel"); // Rule name
                response.setCondition("Weight exceeds 10kg");
                response.setDeliveryCost(weight * costConfig.getHeavyCost());
            } else if (weight <= heavyWeight) { // non heavy weight parcel
                final double height = parcel.getHeight();
                final double width = parcel.getWidth();
                final double length = parcel.getLength();

                final double smallParcel = costConfig.getParcelSmall();
                final double mediumParcel = costConfig.getParcelMedium();
                
                final double volume = ((height * width) * length);
                
                if (volume < smallParcel) { // small parcel
                    response.setPriority((byte) 3);
                    response.setStatus("Small Parcel"); // Rule name
                    response.setCondition("Volume is less than 1500cm");
                    response.setDeliveryCost(volume * costConfig.getSmallCost());
                } else if (volume < mediumParcel) { // medium parcel
                    response.setPriority((byte) 4);
                    response.setStatus("Medium Parcel"); // Rule name
                    response.setCondition("Volume is less than 2500cm");
                    response.setDeliveryCost(volume * costConfig.getMediumCost());
                } else {
                    response.setPriority((byte) 5);
                    response.setStatus("Large Parcel"); // Rule name
                    response.setCondition("Volume is large parcel");
                    response.setDeliveryCost(volume * costConfig.getLargeCost());
                }
            }
        }

        return response;
    }
    
}
