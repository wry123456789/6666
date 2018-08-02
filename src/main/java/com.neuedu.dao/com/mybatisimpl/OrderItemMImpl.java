package com.neuedu.dao.com.mybatisimpl;


import com.neuedu.dao.OrderDao;
import com.neuedu.dao.OrderItemDao;
import com.neuedu.dao.impl.jdbc.OrderItemDaoImpl;
import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class OrderItemMImpl implements OrderItemDao{

    @Override
    public boolean addOrderItems(int id, double totalprice) {
        return false;
    }

    @Override
    public boolean addOrderItems(UserOrderItem userOrderItem) {
        SqlSessionFactory sqlSessionFactory= MybatisUtil.getSqlSession();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        OrderItemDao c=sqlSession.getMapper(OrderItemDao.class);
        boolean ss= c.addOrderItems(userOrderItem);
        sqlSession.commit();
        System.out.println("´´½¨¶©µ¥"+ss);
        return ss;
    }

    @Override
    public List<UserOrderItem> selectItem(long order) {
        List<UserOrderItem> list = null;
        SqlSessionFactory sqlSessionFactory= MybatisUtil.getSqlSession();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        OrderItemDao c=sqlSession.getMapper(OrderItemDao.class);
        list= c.selectItem(order);
        sqlSession.commit();
        return list;
    }

    @Override
    public int generateOrderItemId() {
        return 0;
    }
}