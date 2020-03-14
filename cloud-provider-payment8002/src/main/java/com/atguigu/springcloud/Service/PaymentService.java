package com.atguigu.springcloud.Service;

import com.atguigu.springcloud.Dao.PaymentDao;
import com.atguigu.springcloud.Entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lxf
 * @create: 2020-03-09 10:34
 * @description:
 */
@Service
public class PaymentService {
    @Autowired
    private PaymentDao paymentDao;
    public Payment queryPaymentById(Long id) {
       return paymentDao.queryPaymentById(id);
    }

    public void insertPayment(Payment payment) {
        paymentDao.insertPayment(payment);
    }

    public List<Payment> queryPaymentAll() {
        return  paymentDao.queryPaymentAll();
    }

    public void updatePayment(Payment payment) {
        paymentDao.updatePayment(payment);
    }

    public void deletePayment(List<Long> ids) {
        paymentDao.deletePayment(ids);
    }
}
