package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.exceptions.fareexceptions.FareNullException;
import com.uni_sabios.repository.RepositoryFare;
import com.uni_sabios.repository.models.Fare;
import com.uni_sabios.services.ServiceFare;

public class ServiceFareImpl implements ServiceFare{

    private final RepositoryFare crudRepositoryFare;

    public ServiceFareImpl(RepositoryFare crudRepositoryFare){
        this.crudRepositoryFare = crudRepositoryFare;
    }

    @Override
    public List<Fare> list() {
        return this.crudRepositoryFare.list();
    }

    @Override
    public Fare getFare(int fareId) throws FareNullException {
        Fare fare = this.crudRepositoryFare.getFare(fareId);
        if(fare != null) {
            return fare;
        }else {
            throw new FareNullException("No Fare with this ID was found");
        }
    }

    @Override
    public void create(Fare fare) {
        this.crudRepositoryFare.create(fare);
    }

    @Override
    public void modify(Fare fare) {
        this.crudRepositoryFare.modify(fare);
    }

    @Override
    public int getFarebyPeriodSubject(String document, int period) throws FareNullException {
        int fare = this.crudRepositoryFare.getFarebyPeriodSubject(document, period);
        if(fare != 0) {
            return fare;
        }else {
            throw new FareNullException("No Fare with this ID was found");
        }
    }
    
}
