package com.quotes.premium.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CibilScoreRequest {

    private boolean cibil;
    private int cibilScore; // TODO change cibil logic.
}
