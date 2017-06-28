package mapper;

import org.apache.ibatis.annotations.*;
import pojo.Emp;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
public interface EmpMapper {

    @Select("SELECT empid,ename,hiredate,photo FROM emps")
    List<Emp> selectAll();

    @Select("SELECT empid,ename,hiredate,photo FROM emps WHERE empid = #{empid}")
    Emp selectById(String empid);

    @SelectProvider(type = EmpSQLProvide.class,method = "getSelectSql")
    List<Emp> selectByInfo(String info);

    @Insert("INSERT INTO emps(empid,ename,hiredate,photo) " +
            "VALUES (#{empid},#{ename},#{hiredate},#{photo})")
    int insert(Emp emp);

    @Delete("DELETE FROM emps WHERE empid=#{empid}")
    int delete(String empid);

    @Update("UPDATE emps SET ename=#{ename},hiredate=#{hiredate},photo=#{photo} " +
            "WHERE empid=#{empid}")
    int update(Emp emp);

}
