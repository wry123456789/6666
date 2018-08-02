package com.neuedu.dao.com.mybatisimpl;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Page;
import com.neuedu.entity.Product;
import com.neuedu.utils.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductMImpl implements ProductDao {
    @Override
    public boolean addProduct(Product product) {
        SqlSessionFactory  s =MybatisUtil.getSqlSession();
        SqlSession ss=s.openSession();
        int sss=ss.insert("com.neuedu.entity.Account.addProduct",product);
        System.out.println(sss);
        ss.commit();
        return true;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public boolean updateProduct(Product product) {

        SqlSessionFactory sqlSessionFactory= MybatisUtil.getSqlSession();
        SqlSession sqlSession= sqlSessionFactory.openSession(true);
        int s=sqlSession.update("com.neuedu.entity.Account.updateProduct",product);
        return true;
    }

    @Override
    public boolean deleteProduct(int id) {
        SqlSessionFactory sqlSessionFactory= MybatisUtil.getSqlSession();
        SqlSession sqlSession= sqlSessionFactory.openSession(true);
        int s=sqlSession.delete("com.neuedu.entity.Account.deleteProduct",id);
        return true;
    }

    @Override
    public Product findById(int id) {
        SqlSessionFactory sqlSessionFactory= MybatisUtil.getSqlSession();
        SqlSession sqlSession= sqlSessionFactory.openSession(true);
        Product p =sqlSession.selectOne("com.neuedu.entity.Account.findById");
        return p;

    }

    @Override
    public Page<Product> findProductByPage(int pageNo, int pageSize) {
        //查出总页数通过总记录/每页记录
        //1.和数据库建立连接
       SqlSessionFactory sqlSessionFactory= MybatisUtil.getSqlSession();
       SqlSession sqlSession= sqlSessionFactory.openSession();
        System.out.println(0);
       int totalCount= sqlSession.selectOne("com.neuedu.entity.Account.findT");
       System.out.println(totalCount);
       int totalPage = (totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
        //2.每页的记录
        Map <String ,Object>map = new HashMap();
        int offset =(pageNo-1)*pageSize;
        map.put("offset",offset);
        map.put("pageSize",pageSize);
        List<Product> l= sqlSession.selectList("com.neuedu.entity.Account.findProductByPage",map);
         Page<Product> p = new Page<Product>();
         p.setPage(l);
         p.setTotalPage(totalPage);
         p.setCurrent(pageNo); //这是一页的
        //3.当前页
        return p;
    }

    @Override
    public List<Product> findByName(String name) {
        SqlSessionFactory sqlSessionFactory =MybatisUtil.getSqlSession();
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        List<Product>list=sqlSession.selectList("com.neuedu.entity.Account.findByName",name) ;
        return list;
    }
    public List<String> findCategoryName(){
        SqlSessionFactory sqlSessionFactory =MybatisUtil.getSqlSession();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<String> list= sqlSession.selectList("com.neuedu.entity.Account.findCategoryName");
        return list;
    }

}
