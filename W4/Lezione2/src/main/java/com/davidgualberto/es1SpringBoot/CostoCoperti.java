package com.davidgualberto.es1SpringBoot;

import org.springframework.beans.factory.annotation.Value;

public class CostoCoperti {
		@Value("${CostoCoperti.costo}")
		int costo;
}
