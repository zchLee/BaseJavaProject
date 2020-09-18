package com.lea.day9;

/**
 * @author aCheng
 * @create 2020/09/02 上午 10:28
 */
public class Order {

    private String orderNo;

    private Double amount;

    private String payPerson;

    public Order(String orderNo, Double amount, String payPerson) {
        this.orderNo = orderNo;
        this.amount = amount;
        this.payPerson = payPerson;
    }

    public Order() {
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPayPerson() {
        return payPerson;
    }

    public void setPayPerson(String payPerson) {
        this.payPerson = payPerson;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", amount=" + amount +
                ", payPerson='" + payPerson + '\'' +
                '}';
    }
}
