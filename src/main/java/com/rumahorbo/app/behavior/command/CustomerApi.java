package com.rumahorbo.app.behavior.command;

public class CustomerApi implements Api {

    @Override
    public String getCustomerIdentity(CustomerIdentityParamApi customerIdentityParamApi) {
        return "Get customer identity from server with nik: " + customerIdentityParamApi.getNik();
    }

    @Override
    public String getCustomerAccounts(CustomerAccountParamApi customerAccountParamApi) {
        return "Get customer accounts from server with cif: " + customerAccountParamApi.getCif();
    }
}
