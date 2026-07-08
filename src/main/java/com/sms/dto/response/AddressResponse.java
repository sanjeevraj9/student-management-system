package com.sms.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponse {
    private Long id;
    private String houseNo;
    private String street;
    private String city;
    private String state;
    private String pincode;
    private String addressType;
}
