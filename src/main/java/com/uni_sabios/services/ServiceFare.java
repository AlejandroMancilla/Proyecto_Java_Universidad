package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.exceptions.fareexceptions.FareNullException;
import com.uni_sabios.repository.models.Fare;

public interface ServiceFare {

    List<Fare> list();

    Fare getFare(int fareId) throws FareNullException;

    void create(Fare fare);

    void modify(Fare fare);

}
