package com.feeltech.appbee.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class Config {

    @Value("${ambiente.descricao}")
    private String descAmbienteProperties;

}
