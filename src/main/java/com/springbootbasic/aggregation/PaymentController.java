package com.springbootbasic.aggregation;

import com.springbootbasic.aggregation.querydsl.MachineService;
import com.springbootbasic.aggregation.querydsl.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class PaymentController {

    private PaymentService paymentService;

    private MachineService machineService;

    @GetMapping("/getPaymentListBetween2019To2020")
    public ResponseEntity<?> getPaymentListBetween2019To2020(){
        return ResponseEntity.ok().body(paymentService.getPaymentListBetween2019To2020());
    }

    @GetMapping("/getAllMachine")
    public ResponseEntity<?> getAllMachine(){
        return ResponseEntity.ok().body(machineService.machineList());
    }

    @GetMapping("/getMachinePaymentCounts")
    public ResponseEntity<?> getMachinePaymentCounts(){
        return ResponseEntity.ok().body(paymentService.getMachinePaymentCounts());
    }

    @GetMapping("/getValidMachinesPayments")
    public ResponseEntity<?> getValidMachinesPayments(){
        return ResponseEntity.ok().body(paymentService.getMachinePaymentCounts_excludePaymentApprovalYearIsNull());
    }
}
