package com.lzr.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 表名 :  employrole_info<br/>
 */
@JsonIgnoreProperties(value = "handler")
public class EmployroleInfo implements Serializable {

    /**
     * 用户角色id
     */
    private Integer id;
    /**
     * 角色对象
     */
    private RoleInfo rid;
    /**
     * 用户员工对象
     */
    private Employ empid;

    public EmployroleInfo() {
        super();
    }

    public EmployroleInfo(Integer id, RoleInfo rid, Employ empid) {
        this.id = id;
        this.rid = rid;
        this.empid = empid;
    }

    /**
     * 设置"用户角色id"
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取"用户角色id"
     */
    public Integer getId() {
        return id;
    }

    public void setRid(RoleInfo rid) {
        this.rid = rid;
    }

    public RoleInfo getRid() {
        return rid;
    }

    public void setEmpid(Employ empid) {
        this.empid = empid;
    }

    public Employ getEmpid() {
        return empid;
    }

    @Override
    public String toString() {
        return "employrole_info[" +
                "id = " + id +
                ", rid = " + rid +
                ", empid = " + empid +
                "]";
    }
}

