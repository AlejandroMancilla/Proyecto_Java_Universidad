package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.repository.models.Fare;

public interface RepositoryFare {

    List<Fare> list();

    Fare getFare(int fareId);

    int getFarebyPeriodSubject(String document, int period);

    void create(Fare fare);

    void modify(Fare fare);

    void delete(Fare fare);

}
