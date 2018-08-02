package com.neuedu.dao.com.mybatisimpl;


import com.neuedu.dao.CartDao;
import com.neuedu.dao.OrderDao;
import com.neuedu.entity.UserOrder;
import com.neuedu.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class OrderMImpl implements OrderDao{
    @Override
    public boolean createOrder(UserOrder userOrder) {
        SqlSessionFactory sqlSessionFactory= MybatisUtil.getSqlSession();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        OrderDao c=sqlSession.getMapper(OrderDao.class);
        boolean ss= c.createOrder(userOrder);
        sqlSession.commit();
        System.out.println("创建订单"+ss);
        return ss;
    }

    @Override
    public int generateOrderId() {
        return 0;
    }

    @Override
    public List<UserOrder> selectOrder(int userId) {
        SqlSessionFactory sqlSessionFactory= MybatisUtil.getSqlSession();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        OrderDao c=sqlSession.getMapper(OrderDao.class);
        List<UserOrder> u = null;
        u= c.selectOrder(userId);
        sqlSession.commit();

        return u;

    }
}