package com.gzy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 部门
 *
 * @author zygui
 * @date 2020/4/1 16:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private Integer id; // 部门id
    private String departmentName; // 部门名
}
