package com.quotes.premium.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Applicable {
    private Double basePremium = 0.0d;
    private Double lookup = 0.0d;
    private Double zonalDiscount = 0.0d;
    private Double floater = 0.0d;
    private Double preferredHospitalNetwork = 0.0d;
    private Double copay = 0.0d;
    private Double deductible = 0.0d;
    private Double superstarBonus = 0.0d;
    private Double instantCover = 0.0d;
    private Double consumableCover = 0.0d;
    private Double futureReady = 0.0d;
    private Double pedWaitingPeriod = 0.0d;
    private Double specificDisease = 0.0d;
    private Double limitlessCare = 0.0d;
    private Double sharedRoomDiscount = 0.0d;
    private Double subLimitModeration = 0.0d;
    private Double medicalEquipmentCover = 0.0d;
    private Double wellnessDiscount = 0.0d;
    private Double nriDiscount = 0.0d;
    private Double roomRent = 0.0d;
    private Double maternityExpense = 0.0d;
    private Double womenCare = 0.0d;
    private Double highEndDiagnostic = 0.0d;
    private Double annualHealthCheckUp = 0.0d;
    private Double internationalSecondOpinion = 0.0d;
    private Double compassionateVisit = 0.0d;
    private Double hospitalCash = 0.0d;
    private Double paCover = 0.0d;
    private Double healthQuestionnaire = 0.0d;
    private Double cibilDiscount = 0.0d;
    private Double earlyRenewal = 0.0d;
    private Double longTermDiscount = 0.0d;
    private Double reflexLoading = 0.0d;

    private String type;
    private int age;
    private int year;
    private List<String> peds = new ArrayList<>();
    private boolean nri;
    private boolean proposer;
    private Double reflexLoadingPercentage = 0.0d;

    public void handleStageIIPremium() {
        this.basePremium =
                this.basePremium
                        + this.maternityExpense
                        + this.womenCare
                        + this.highEndDiagnostic
                        + this.annualHealthCheckUp
                        + this.internationalSecondOpinion
                        + this.compassionateVisit
                        + this.hospitalCash
                        + this.paCover;
    }

    public void handleStageIIIPremium() {
        this.basePremium = Math.max(
                this.basePremium
                    - this.healthQuestionnaire
                    - this.cibilDiscount
                    - this.earlyRenewal
                ,
                this.basePremium -
                        this.basePremium*0.20d
        );
    }
}
