package com.stocks.entity;
import static org.junit.Assert.assertFalse;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test; 
 
public class TradeValidationTest { 
 
    private static Validator validator;
 
    @Before 
    public void setUp() { 
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    } 
    @Test
    public void testContactSuccess() { 
       Trades trades = new Trades();
       trades.setStockName("abc");
       trades.setBuySellIndicator(BuySellIndicator.B);
       trades.setSettlementDate(new Date());
       trades.setTradeDate(new Date());
        Set<ConstraintViolation<Trades>> violations = validator.validate(trades);
        assertFalse(violations.isEmpty());
    } 
}