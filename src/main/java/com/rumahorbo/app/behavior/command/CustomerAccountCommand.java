package com.rumahorbo.app.behavior.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerAccountCommand implements Command {
    private final Api customerApi;
    private final CustomerAccountParamApi customerAccountParamApi;

    @Override
    public String apiGetDetailCustomer() {
        return customerApi.getCustomerAccounts(this.customerAccountParamApi);
    }
}
