package me.waterdragon;

import me.waterdragon.di.Inject;

public class AccountService {
	@Inject
	AccountRepository accountRepository;

	public void join() {
		System.out.println("service.join()");
		accountRepository.save();
	}
}
