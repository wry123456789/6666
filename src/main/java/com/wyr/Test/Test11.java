package com.wyr.Test;

import com.neuedu.dao.AddressDao;
import com.neuedu.dao.impl.jdbc.AddressDaoImpl;

import com.neuedu.dao.impl.jdbc.OrderDaoImpl;
import com.neuedu.entity.Address;
import com.neuedu.entity.UserOrder;

import java.util.List;


public class Test11 {
    public static void main(String[]args){

        OrderDaoImpl or = new OrderDaoImpl();

//      List<Address> list= ad.findAll();
//      for(Address a:list){
//          System.out.println(a.getFreight());
//      }
      List<UserOrder> l= or.findAll();
     for(int i =0;i<l.size();i++){
         System.out.println(l.get(i));
     }

    }
}
