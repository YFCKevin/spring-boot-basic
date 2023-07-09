package com.springbootbasic.aggregation.querydsl;

import lombok.Data;

@Data
public class MachinePaymentDTO {

    private String machineName;
    private String paymentName;
    private Integer registerYear;
    private Integer approvalYear;
}
