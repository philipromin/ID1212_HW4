package com.philip.currency.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.philip.currency.domain.Currency;
import com.philip.currency.repository.CurrencyRepo;

import org.springframework.transaction.annotation.Propagation;


@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
@Service
public class CurrencyService {
	@Autowired
	private CurrencyRepo repository;
	 
    public Currency getCurrency(String name){
    	return repository.findByName(name);
    }
    
    public List<Currency> getCurrencies(){
        List<Currency> currencies = new ArrayList<Currency>();
        repository.findAll().forEach(currencies::add);
        return currencies;
    }
    
    public void addCurrency(Currency currency) {
    	repository.save(currency);
    }
}
