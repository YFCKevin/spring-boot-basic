package com.springbootbasic.aggregation.querydsl;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MachinePaymentDTO {

    private String machineName;
    private String paymentName;
    private Integer registerYear;
    private Integer approvalYear;
}
