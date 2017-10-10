package com.kk.service;

import java.sql.SQLException;

import com.kk.dao.MonDao;
import com.kk.dao.MoneyHandle;
import com.kk.dao.Select;
import com.kk.domain.account;
import com.kk.utils.MyDateSourceUtil;

public class GiveMoneyServlet {

		public static int transfer(String user1, String user2, int money) {
		
			
			try {
				MyDateSourceUtil.startTranscation();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return 15;
			}
			
			account acc=null;
			try {
				acc = Select.selectForName(user1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("---");
			}
			
			
			
			
			if(acc.getMoney()<money) {
				System.out.println("金额不够");
				return 1;
			}
			
			
			try {
				MoneyHandle.ductMoney(acc, money);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				try {
					MyDateSourceUtil.rollbackTranscation();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return 4;
				}
				return 2;
			}
		
		
			
			try {
				acc = Select.selectForName(user1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("查无此人");
				return 0;
			}
		
			
			try {
				MoneyHandle.reChargeMoney(acc,money);
			} catch (SQLException e) {
				try {
					MyDateSourceUtil.rollbackTranscation();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					return 4;
				}
				return 2;
			}
			
			
			try {
				MyDateSourceUtil.commitTranscation();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 2;
			}
			return 3;
	}

}
