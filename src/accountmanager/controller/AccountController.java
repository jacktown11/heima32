package accountmanager.controller;

import java.util.List;

import accountmanager.domain.AccountItem;
import accountmanager.domain.QueryCondition;
import accountmanager.service.AccountService;

public class AccountController {
	private static AccountService service = new AccountService();
	
	public int add(AccountItem item	) {
		return service.add(item);
	}
	
	public int deleteById(int id) {
		return service.deleteById(id);
	}
	
	public int update(AccountItem item) {
		return service.update(item);
	}
	
	public List<AccountItem> query(QueryCondition cond){
		return service.query(cond);
	}
}
