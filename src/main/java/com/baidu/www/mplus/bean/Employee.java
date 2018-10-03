package com.baidu.www.mplus.bean;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;


/**
 * @author liuyangos8888
 * <p>
 * 实体类
 * 建议使用封装类型String，Integer，方便框架判空
 */

public class Employee extends Model<Employee> {

    /**
     * 字段的ID
     */
    private Integer id;

    /**
     * 名字
     */
    private String lastName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }

    /**
     * 指定当前实体类的主键属性
     *
     * @return
     */
    @Override
    protected Serializable pkVal() {
        return id;
    }
}
