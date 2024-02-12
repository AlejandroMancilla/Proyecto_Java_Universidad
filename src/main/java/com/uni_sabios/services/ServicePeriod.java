package com.uni_sabios.services;

import java.util.List;

import com.uni_sabios.exceptions.periodexceptions.PeriodExceptionInsertDataBase;
import com.uni_sabios.exceptions.periodexceptions.PeriodNullException;
import com.uni_sabios.repository.models.Period;

public interface ServicePeriod {

    List<Period> list();

    Period getPeriod(int periodId) throws PeriodNullException;

    void create(Period period) throws PeriodExceptionInsertDataBase;

    void update(Period period);

}
