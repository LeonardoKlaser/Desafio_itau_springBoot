package com.desafio.itau.desafioItauSpringBoot.services;

import com.desafio.itau.desafioItauSpringBoot.dto.StatiscDto;
import com.desafio.itau.desafioItauSpringBoot.interfaces.ITransactionService;
import com.desafio.itau.desafioItauSpringBoot.model.Transaction;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class TransactionService implements ITransactionService {
    private final Queue<Transaction> transactionsDatabase = new ConcurrentLinkedDeque<>();
    @Override
    public void insert(Transaction transaction) {
        transactionsDatabase.add(transaction);
    }

    @Override
    public void deleteAll() {
        transactionsDatabase.clear();
    }

    @Override
    public DoubleSummaryStatistics getStatistcs() {
        OffsetDateTime now = OffsetDateTime.now();
        return transactionsDatabase.stream()
                //.filter(t -> t.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();
    }
}
