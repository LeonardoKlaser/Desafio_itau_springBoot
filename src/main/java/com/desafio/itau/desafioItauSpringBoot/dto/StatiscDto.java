package com.desafio.itau.desafioItauSpringBoot.dto;

import java.util.DoubleSummaryStatistics;

public class StatiscDto {
    public Long count;
    public Double sum;
    public Double avg;
    public Double min;
    public Double max;


    public StatiscDto(DoubleSummaryStatistics summaryStatistics){
        this.count = summaryStatistics.getCount();
        this.sum = summaryStatistics.getSum();
        this.avg = summaryStatistics.getAverage();
        this.min = summaryStatistics.getMin();
        this.max = summaryStatistics.getMax();
    }

    public Long getCount() {
        return count;
    }

    public Double getSum() {
        return sum;
    }

    public Double getAvg() {
        return avg;
    }

    public Double getMin() {
        return min;
    }

    public Double getMax() {
        return max;
    }
}
