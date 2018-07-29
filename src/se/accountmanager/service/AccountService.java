package se.accountmanager.service;

import java.util.List;

import se.accountmanager.dao.QueryServer;
import se.accountmanager.domain.AccountItem;
import se.accountmanager.domain.QueryCondition;

public class AccountService {
	private QueryServer server = new QueryServer();
	
	public int add(AccountItem item	) {
		return server.add(item);
	}
	
	public int deleteById(int id) {
		return server.deleteById(id);
	}
	
	public int update(AccountItem item) {
		return server.update(item);
	}
	
	public List<AccountItem> query(QueryCondition cond){
		return server.query(cond);
	}
}
