package com.springbootbasic.aggregation.querydsl;

import lombok.Data;

@Data
public class MachinePaymentCount {

    private String machineName;
    private Long paymentCount;
}
