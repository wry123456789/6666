package com.wyr.Test;


import com.neuedu.dao.CartDao;
import com.neuedu.dao.com.mybatisimpl.CartMImpl;
import com.neuedu.dao.com.mybatisimpl.CategoryMImpl;
import com.neuedu.dao.com.mybatisimpl.ProductMImpl;
import com.neuedu.entity.Account;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Test11 {
    public static void main(String[]args) {

Collection co = new ArrayList();
co.add("1");
co.add("2");
co.remove("1");
Iterator i = co.iterator();
while(i.hasNext()){
   System.out.println(i.next()) ;
   i.remove();
}
System.out.println(co);
    }
    }


