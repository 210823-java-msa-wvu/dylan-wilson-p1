package com.dylan.models;

import javax.persistence.*;

@Entity
@Table(name = "\"TRMS\".account_balance")
public class AccountBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private Integer balance;

    public AccountBalance() {}


    public AccountBalance(Integer balance) {
        this.balance = balance;
    }

    public AccountBalance(Integer user_id, Integer balance) {
        this.user_id = user_id;
        this.balance = balance;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountBalance{" +
                "user_id=" + user_id +
                ", balance=" + balance +
                '}';
    }
}
