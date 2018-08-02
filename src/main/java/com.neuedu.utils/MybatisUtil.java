package com.neuedu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class MybatisUtil {
 public static   SqlSessionFactory  sqlSessionFactory=null;
    static{
        InputStream r =null;

        try {
            r = Resources.getResourceAsStream("Mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(r);
        }

        public static SqlSessionFactory getSqlSession( ) {
             return sqlSessionFactory;
        }
        public static void closeSqlSession(SqlSession sqlSession){
               sqlSession.close();
        }
    }

