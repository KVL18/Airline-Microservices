package com.kvl.payload.request;


import com.kvl.enums.AirlineStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirlineRequest {

    @NotBlank(message = "iataCode is required")
    @Size
    private String iataCode;

    @NotBlank
    @Size
    private String iacoCode;

    @NotBlank
    private String name;

    private String alias;

    @NotBlank
    private String country;

    private String logoUrl;
    private String website;

    private AirlineStatus status;

    private String alliance;
    private Long headquartersCityId;

    private String supportEmail;
    private String supportPhone;
    private String supportHours;


}
