package com.samples;

import java.util.ArrayList;
import java.util.List;

import com.sample.model.VehicleType;

public class VehicleService {
	
	
	public List getAvailableBrands(VehicleType type){

        List brands = new ArrayList();

        if(type.equals(VehicleType.HATCHBACK)){
            brands.add("Maruti Suzuki Swift");
            brands.add(("Hyundai Santro"));

        }else if(type.equals(VehicleType.SUV)){
            brands.add("Hyundai Creta");
            brands.add("KIA Seltos");

        }else if(type.equals(VehicleType.SEDAN)){
            brands.add("Hyundai Verna");
            brands.add("Honda City");
            brands.add("BMW 3 Series");

        }else {
            brands.add("No Brand Available");
        }
    return brands;
    }
	
	
	
	

}
