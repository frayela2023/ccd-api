package com.mymt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ParcelCostConfig {

    @Value("${parcel.exceeds}")
    String exceedsParcel;

    @Value("${parcel.heavy}")
    String heavyParcel;

    @Value("${parcel.medium}")
    String mediumParcel;

    @Value("${parcel.small}")
    String smallParcel;


    public Double getParcelExceeds() {
        return Double.parseDouble(exceedsParcel);
    }

    public void setParcelExceeds(String parcel) {
        this.exceedsParcel = parcel;
    }

    public Double getParcelHeavy() {
        return Double.parseDouble(heavyParcel);
    }

    public void setParcelHeavy(String parcel) {
        this.heavyParcel = parcel;
    }
    
    public Double getParcelMedium() {
        return Double.parseDouble(mediumParcel);
    }

    public void setParcelMedium(String parcel) {
        this.mediumParcel = parcel;
    }

    public Double getParcelSmall() {
        return Double.parseDouble(smallParcel);
    }

    public void setParcelSmall(String parcel) {
        this.smallParcel = parcel;
    }


    @Value("${parcel.cost.heavy}")
    String heavyCost;

    @Value("${parcel.cost.small}")
    String smallCost;

    @Value("${parcel.cost.medium}")
    String mediumCost;

    @Value("${parcel.cost.large}")
    String largeCost;

    public Double getHeavyCost() {
        return Double.parseDouble(heavyCost);
    }

    public void setHeavyCost(String parcel) {
        this.heavyCost = parcel;
    }

    public Double getSmallCost() {
        return Double.parseDouble(smallCost);
    }

    public void setSmallCost(String parcel) {
        this.smallCost = parcel;
    }

    public Double getMediumCost() {
        return Double.parseDouble(mediumCost);
    }

    public void setMediumCost(String parcel) {
        this.mediumCost = parcel;
    }

    public Double getLargeCost() {
        return Double.parseDouble(largeCost);
    }

    public void setLargeCost(String parcel) {
        this.largeCost = parcel;
    }

}
