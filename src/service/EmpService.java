package service;

import mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Emp;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27 0027.
 */

@Service
public class EmpService {

    @Autowired
    private EmpMapper empMapper;

    //通过empid查找
    public Emp findById(String empid) {
        return empMapper.selectById(empid);
    }

    //查找所有
    public List<Emp> findAll() {
        return empMapper.selectAll();
    }

    //模糊查找
    public List<Emp> findByInfo(String info) {
        return empMapper.selectByInfo(info);
    }

    //新建一个Emp
    @Transactional
    public int add(Emp emp) {
        return empMapper.insert(emp);
    }

    //通过empid删除一个
    @Transactional
    public int remove(String empid) {
        return empMapper.delete(empid);
    }

    //通过empid修改一个
    @Transactional
    public int alter(Emp emp ) {
        return empMapper.update(emp);
    }


}
