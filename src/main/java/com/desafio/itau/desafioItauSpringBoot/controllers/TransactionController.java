package com.desafio.itau.desafioItauSpringBoot.controllers;

import com.desafio.itau.desafioItauSpringBoot.dto.StatiscDto;
import com.desafio.itau.desafioItauSpringBoot.dto.TransactionDto;
import com.desafio.itau.desafioItauSpringBoot.model.Transaction;
import com.desafio.itau.desafioItauSpringBoot.services.TransactionService;
import com.sun.jdi.request.ExceptionRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/transaction")
public class TransactionController{
    private final TransactionService _service;

    public  TransactionController(TransactionService service){
        _service = service;
    }

    @PostMapping
    public ResponseEntity<Void> insertTransaction (@Valid @RequestBody TransactionDto request){
        if(request.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(60)) || request.getValor() < 0){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        };

        try{
            _service.insert(new Transaction(request.getValor(), request.getDataHora()));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllTransactions(){
        try{
            _service.deleteAll();
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
    }

    @GetMapping
    public StatiscDto getStatiscs(){
        try{
            DoubleSummaryStatistics stats =  _service.getStatistcs();
            return new StatiscDto(stats);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }


}
