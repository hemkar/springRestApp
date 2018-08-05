package com.stocks.dao;

import java.util.List;

import com.stocks.entity.Trades;

public interface StockDAO {

	public List<Trades> getAllTradeForBroker(String brokerId);

	public List<Trades> getTopFiveStocks(String buySellIndicator);
	
}
