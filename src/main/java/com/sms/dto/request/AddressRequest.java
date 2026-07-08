package com.sms.dto.request;

import lombok.Data;

@Data
public class AddressRequest {
    private String houseNo;
    private String street;
    private String city;
    private String state;
    private String pincode;
    private String addressType;
}
