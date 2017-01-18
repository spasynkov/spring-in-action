package com.springinaction.pizza;

import com.springinaction.pizza.domain.Customer;
import com.springinaction.pizza.domain.Order;
import com.springinaction.pizza.domain.Payment;
import com.springinaction.pizza.domain.PaymentDetails;
import com.springinaction.pizza.exceptions.CustomerNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fat Faggy on 16.01.2017.
 */
public class PizzaFlowActions {

    private Order order;
    private List<Customer> customers = new ArrayList<>();

    public void saveOrder(Order order) {
        this.order = order;
    }

    public Customer lookupCustomer(String phoneNumber) {
        for (Customer customer : customers) {
            if (phoneNumber.equals(customer.getPhoneNumber())) return customer;
        }
        throw new CustomerNotFoundException();
    }

    public boolean checkDeliveryArea(String zipCode) {
        return !zipCode.isEmpty();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Payment verifyPayment(PaymentDetails details) {
        return new Payment();
    }
}
