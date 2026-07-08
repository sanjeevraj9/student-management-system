package com.sms.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressRequest {
    @NotBlank(message = "House No is Required")
    private String houseNo;
    @NotBlank(message = "Street is Required")
    private String street;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "State is Required")
    private String state;
    @Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be 6 digit")
    private String pincode;
    @NotBlank(message = "Please Give Address Type")
    private String addressType;
}
