package com.philip.currency.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.philip.currency.domain.Currency;

@Repository
public interface CurrencyRepo extends CrudRepository<Currency, Long> {
	@Transactional
	Currency findByName(String name);
}
