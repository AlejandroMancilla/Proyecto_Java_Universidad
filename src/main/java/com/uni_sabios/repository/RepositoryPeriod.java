package com.uni_sabios.repository;

import java.util.List;

import com.uni_sabios.exceptions.periodexceptions.PeriodExceptionInsertDataBase;
import com.uni_sabios.repository.models.Period;

public interface RepositoryPeriod {
    
    public List<Period> list();
    
    public Period getPeriod(int periodId);
        
    public void create(Period period) throws PeriodExceptionInsertDataBase;
    
    public void modify(Period period);
    
}
