package com.rumahorbo.app.behavior.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerIdentityCommand implements Command {

    private final Api customerApi;
    private final CustomerIdentityParamApi customerParamApi;

    @Override
    public String apiGetDetailCustomer() {
        return this.customerApi.getCustomerIdentity(this.customerParamApi);
    }
}
