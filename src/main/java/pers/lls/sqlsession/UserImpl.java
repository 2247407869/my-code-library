package pers.lls.sqlsession;

import org.mybatis.spring.SqlSessionTemplate;

import java.util.Map;

public class UserImpl {
    //注入以后就可以直接使用sqlsession
    private SqlSessionTemplate sqlsession;
    public void setSqlsession(SqlSessionTemplate sqlsession) {
        this.sqlsession = sqlsession;
    }
    //用sqlsession去操作数据库
    public void insert(Map user){
        sqlsession.insert("UserMapper.insert", user);
    }
    public void findById(int id){
        sqlsession.selectOne("UserMapper.findById", id);
        System.out.println((String) sqlsession.selectOne("UserMapper.findById", id));
        //因为输出值是一个map集合，所以打印一个map
    }
}
