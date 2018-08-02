package com.neuedu.dao.com.mybatisimpl;

import com.neuedu.dao.CartDao;
import com.neuedu.entity.Account;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartMImpl implements CartDao {
    @Override
    public boolean addCart(int productid, int productnum, int accountid) {
       return false;
    }

    @Override
    public boolean addCart(Cart cart) {
      Account acc=  cart.getAcc();
      Product p = cart.getProduct();
      int accountid = acc.getAccountId();
      int productid= p.getId();
      int productNum = cart.getProductNum();
        List<Cart>lc=findAllCart(accountid);
        for (Cart cart1 : lc) {
            if(cart1.getProduct().getId()==productid) {
                int num=cart1.getProductNum();
                cart1.setProductNum(num+productNum);
                updataeCart(cart1);
                return true;
            }
        }
        SqlSessionFactory sqlSessionFactory=MybatisUtil.getSqlSession();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        CartDao c=sqlSession.getMapper(CartDao.class);
        boolean ss= c.addCart(cart);
        sqlSession.commit();
        System.out.println(ss);
        return ss;

    }

    @Override
    public boolean deleteCart(int id) {
        SqlSessionFactory sqlSessionFactory=MybatisUtil.getSqlSession();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        CartDao c=sqlSession.getMapper(CartDao.class);
        boolean ss= c.deleteCart(id);
        sqlSession.commit();
        System.out.println(ss);
        return ss;

    }

    @Override
    public boolean updataeCart(Cart cart) {

        SqlSessionFactory sqlSessionFactory=MybatisUtil.getSqlSession();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        CartDao c=sqlSession.getMapper(CartDao.class);
       boolean ss= c.updataeCart(cart);
        sqlSession.commit();
       System.out.println(ss);
        return ss;
    }

    @Override
    public List<Cart> findAllCart(int accountid) {
        SqlSessionFactory sqlSessionFactory=MybatisUtil.getSqlSession();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        CartDao c=sqlSession.getMapper(CartDao.class);
        List<Cart>cart= c.findAllCart(accountid);
        return cart;
    }

    @Override
    public int getCartNum() {
        return 0;
    }

    @Override
    public boolean updateCart(int id, int num) {
       return false;
    }

    @Override
    public void clearCart() {

    }

    @Override
    public boolean clearCart(int userid) {
        SqlSessionFactory sqlSessionFactory=MybatisUtil.getSqlSession();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        CartDao c=sqlSession.getMapper(CartDao.class);
        boolean ss= c.clearCart(userid);
        sqlSession.commit();
        System.out.println(ss);
        return ss;

    }


    @Override
    public Cart findById(int id) {
        return null;
    }
}
