package com.neuedu.dao.com.mybatisimpl;

import com.neuedu.dao.CategoryDao;
import com.neuedu.entity.Category;
import com.neuedu.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class CategoryMImpl implements CategoryDao{
    @Override
    public boolean addProductCategory(Category c) {
        return false;
    }

    @Override
    public int findCategoryIdByName(String name) {
        SqlSessionFactory sqlSessionFactory=MybatisUtil.getSqlSession();
        SqlSession sqlSession=sqlSessionFactory.openSession();
       int id= sqlSession.selectOne("com.neuedu.entity.Category",name);
        return id;
    }
}
