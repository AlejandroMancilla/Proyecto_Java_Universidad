package com.uni_sabios.services.impl;

import java.util.List;

import com.uni_sabios.exceptions.periodexceptions.PeriodExceptionInsertDataBase;
import com.uni_sabios.exceptions.periodexceptions.PeriodNullException;
import com.uni_sabios.repository.RepositoryPeriod;
import com.uni_sabios.repository.models.Period;
import com.uni_sabios.services.ServicePeriod;

public class ServicePeriodImpl implements ServicePeriod{

    private final RepositoryPeriod crudRepositoryPeriod;

    public ServicePeriodImpl(RepositoryPeriod crudRepositoryPeriod) {
        this.crudRepositoryPeriod = crudRepositoryPeriod;
    }

    @Override
    public List<Period> list() {
        return this.crudRepositoryPeriod.list();
    }

    @Override
    public Period getPeriod(int periodId) throws PeriodNullException {
        Period period = crudRepositoryPeriod.getPeriod(periodId);
        if (period == null) {
            throw new PeriodNullException("Period not found");
        }
        return period;
    }

    @Override
    public void create(Period period) throws PeriodExceptionInsertDataBase {
        this.crudRepositoryPeriod.create(period);
    }

    @Override
    public void update(Period period) {
        this.crudRepositoryPeriod.modify(period);
    }
    
}
