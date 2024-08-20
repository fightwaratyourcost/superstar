package com.quotes.premium.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PremiumResponse implements Serializable {
    private List<Applicable> applicables = new ArrayList<>(); // 5 insured for 5 years person1_year1 . person1_year2
    private long finalPremium = 0;
    private long cgst = 0;
    private long igst = 0;
    private long totalPremium = 0;
    private EmiResponse emiResponse;
    private Double LifestyleDiscount=0.0d;
    private Double totalOptionalCovers=0.0d;
    private Double totalDiscounts=0.0d;


    // TODO add summary for optional covers, discounts , base premium ,

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println(new ObjectMapper().writeValueAsString(PremiumResponse.builder().finalPremium(240030)
                .build()));
    }
}


