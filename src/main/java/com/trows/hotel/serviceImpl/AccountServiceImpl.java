package com.trows.hotel.serviceImpl;

import com.trows.hotel.base.AbstractBaseDao;
import com.trows.hotel.entity.Account;
import com.trows.hotel.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * Created by Throws_exception on 2016/5/27.
 */
@Service
public class AccountServiceImpl extends AbstractBaseDao<Account,Integer> implements AccountService {
}
