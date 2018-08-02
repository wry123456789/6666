//package com.neuedu.dao.com.mybatisimpl;
//
//import com.neuedu.dao.ILoginDao;
//import com.neuedu.entity.Account;
//import com.neuedu.utils.MybatisUtil;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//import static com.neuedu.utils.MybatisUtil.sqlSessionFactory;
//
//public class Mybatisimpl implements ILoginDao {
//    @Override
//    public Account doLogin(String _username, String _password) {
////
//
//        MybatisUtil.getSession();
//        SqlSession s=sqlSessionFactory.openSession();
//        Map<String,String> w = new HashMap<String,String>();
//        w.put("username",_username);
//        w.put("password",_password);
//        Account a=s.selectOne("com.neuedu.entity.Account.login",w);
//        MybatisUtil.closeSqlSession(s);
//        return a;
//    }
////我
//    @Override
//    public boolean register(Account c) {
//        return false;
//    }
//
//    @Override
//    public void addToken(Account c, String token) {
//
//    }
//
//    @Override
//    public String findTokenByAccountId(int accountid) {
//        return null;
//    }
//}
