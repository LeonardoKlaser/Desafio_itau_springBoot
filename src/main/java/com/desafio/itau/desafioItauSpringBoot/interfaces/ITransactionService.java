package com.desafio.itau.desafioItauSpringBoot.interfaces;

import com.desafio.itau.desafioItauSpringBoot.dto.StatiscDto;
import com.desafio.itau.desafioItauSpringBoot.model.Transaction;
import org.springframework.http.ResponseEntity;

import java.util.DoubleSummaryStatistics;

public interface ITransactionService {
    public void insert(Transaction transaction);
    public void deleteAll();
    public DoubleSummaryStatistics getStatistcs();

}
