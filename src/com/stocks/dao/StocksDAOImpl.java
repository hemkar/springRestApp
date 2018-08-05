package com.stocks.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stocks.entity.Trades;

@Repository
public class StocksDAOImpl implements StockDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Trades> getAllTradeForBroker(String brokerId) {
		Session currentSession = sessionFactory.getCurrentSession();

		CriteriaBuilder builder = currentSession.getCriteriaBuilder();
		CriteriaQuery<Trades> criteria = builder.createQuery(Trades.class);
		Root<Trades> tradeRoot = criteria.from(Trades.class);
		criteria.select(tradeRoot);

		criteria.where(builder.equal(tradeRoot.get("brokerCode"), brokerId));
		List<Trades> tradeList = currentSession.createQuery(criteria).getResultList();
		return tradeList;
	}

	@Override
	public List<Trades> getTopFiveStocks(String buySellIndicator) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Trades> query = currentSession
				.createQuery("from Trades as t where t.buySellIndicator= :buySellIndicator order by t.quantity desc");
		query.setParameter("buySellIndicator", buySellIndicator);
		query.setFirstResult(0);
		query.setMaxResults(5);
		List<Trades> result = query.list();

		return result;
	}

}
