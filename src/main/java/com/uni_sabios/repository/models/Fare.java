package com.uni_sabios.repository.models;

import com.uni_sabios.exceptions.periodexceptions.PeriodNullException;
import com.uni_sabios.exceptions.programexceptions.ProgramNullException;
import com.uni_sabios.repository.impl.RepositoryPeriodMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryProgramMysqlImpl;
import com.uni_sabios.services.ServicePeriod;
import com.uni_sabios.services.ServiceProgram;
import com.uni_sabios.services.impl.ServicePeriodImpl;
import com.uni_sabios.services.impl.ServiceProgramImpl;
import com.uni_sabios.utils.Format;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fare {
    
    private int id;
    private int creditValue;
    private int programId;
    private int periodId;
    public static final ServiceProgram serviceProgram = new ServiceProgramImpl(new RepositoryProgramMysqlImpl());
    public static final ServicePeriod servicePeriod = new ServicePeriodImpl(new RepositoryPeriodMysqlImpl());

    public Fare(int creditValue, int programId, int periodId) {

        this.creditValue = creditValue;
        this.programId = programId;
        this.periodId = periodId;

    }

    

    public void print() throws ProgramNullException, PeriodNullException {
        System.out.printf("|%5s|%30s|%10s|%20s|\n", getId(), serviceProgram.getProgram(getProgramId()).getName(), servicePeriod.getPeriod(getPeriodId()).getCode(), Format.formatoMonedaPesos(getCreditValue()));
        System.out.println("+" + "-".repeat(5) + "+" + "-".repeat(30) + "+" + "-".repeat(10) + "+" + "-".repeat(20) + "+");
    }

}