package model;

import model.enums.LoyaltyTier;

public class FrequentFlyerPassenger extends Passenger {
    private LoyaltyTier tier;

    public FrequentFlyerPassenger(String name, String idNumber, String contact, LoyaltyTier tier) {
        super(name, idNumber, contact);
        this.tier = tier;
    }

    public LoyaltyTier getTier() {
        return tier;
    }

    @Override
    public String toString() {

        return (super.toString() + " [" + tier + "]");
    }

}
