package com.philip.currency.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.philip.currency.application.CurrencyService;
import com.philip.currency.domain.Currency;

@Controller
public class CurrencyContr {
    private CurrencyService service;
	
	@Autowired
	public CurrencyContr(CurrencyService service) {
		this.service = service;
		service.addCurrency(new Currency(1, "USD"));
		service.addCurrency(new Currency(0.89, "EUR"));
		service.addCurrency(new Currency(0.76, "GBP"));
		service.addCurrency(new Currency(108, "JPY"));
	}
	@GetMapping("/")
    public String home(Model model){
		model.addAttribute("conversionForm", new ConversionForm());
		model.addAttribute("currencies", service.getCurrencies());
        return "home";
    }
	
	@PostMapping("/convert")
	public String convert(ConversionForm conversionForm, Model model){
		Currency from = service.getCurrency(conversionForm.getFrom());
		Currency to = service.getCurrency(conversionForm.getTo());
		double amount = conversionForm.getAmount();
		
		double result = Converter.ConvertCurrency(amount, from, to);
		model.addAttribute("result", result);
		model.addAttribute("currencies", service.getCurrencies());

		return "home";		
	}
}
