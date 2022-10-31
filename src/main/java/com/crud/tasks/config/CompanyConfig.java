package com.crud.tasks.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CompanyConfig {

    @Value("${info.app.name}")
    private String appName;

    @Value("${info.company.name}")
    private String companyName;

    @Value("${info.company.email}")
    private String companyMail;

    @Value("${info.company.phone}")
    private String companyNumber;

    @Value("${info.app.administrator.address.street}")
    private String companyStreet;

    @Value("${info.app.administrator.address.number}")
    private String companyStreetNumber;
}
