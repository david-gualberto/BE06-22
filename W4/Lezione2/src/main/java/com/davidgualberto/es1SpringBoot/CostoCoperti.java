package com.davidgualberto.es1SpringBoot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@PropertySource("classpath:application.properties")
@Component
public class CostoCoperti {
		@Value("${CostoCoperti.costo}")
		String costo;
}
