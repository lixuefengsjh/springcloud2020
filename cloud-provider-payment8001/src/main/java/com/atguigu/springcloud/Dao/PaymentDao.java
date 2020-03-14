package com.atguigu.springcloud.Dao;

import com.atguigu.springcloud.Entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lxf
 * @create: 2020-03-09 09:21
 * @description:
 */
@Mapper
public interface PaymentDao {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    public Payment queryPaymentById(Long id);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<Payment> queryPaymentAll();

    /**
     * 新增用户
     * @param payment
     */
    public void insertPayment(Payment payment);

    /**
     * 更新用户信息
     * @param payment
     */
    public void updatePayment(Payment payment);

    /**
     * 根据ids删除用户信息
     * @param ids
     */
    public void deletePayment(@Param("ids") List<Long> ids);

}
