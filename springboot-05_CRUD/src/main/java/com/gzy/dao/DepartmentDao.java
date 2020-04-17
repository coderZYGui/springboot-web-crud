package com.gzy.dao;


import com.gzy.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 部门Dao
 */
@Repository
public class DepartmentDao {

	// 模拟数据库中的数据
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101, "D-AA"));
        departments.put(102, new Department(102, "D-BB"));
        departments.put(103, new Department(103, "D-CC"));
        departments.put(104, new Department(104, "D-DD"));
        departments.put(105, new Department(105, "D-EE"));
    }

    // 获得所有部门信息
    public Collection<Department> getDepartments() {
        return departments.values();
    }

    // 通过id得到部门
    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }

}
