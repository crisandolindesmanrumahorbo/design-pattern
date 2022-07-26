package com.rumahorbo.app.behavior.command;

public interface Api {
    String getCustomerIdentity(CustomerIdentityParamApi customerIdentityParamApi);

    String getCustomerAccounts(CustomerAccountParamApi customerAccountParamApi);
}
