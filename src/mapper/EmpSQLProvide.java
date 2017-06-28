package mapper;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
public class EmpSQLProvide {
    public String getSelectSql(String info) {
        return new StringBuilder()
                .append("SELECT empid,ename,hiredate,photo ")
                .append("FROM emps ")
                .append("WHERE empid LIKE '%").append(info).append("%'")
                .append("OR ename LIKE '%").append(info).append("%'")
                .append("OR hiredate LIKE '%").append(info).append("%'")
                .toString();
    }

}
