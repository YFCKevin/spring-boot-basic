package com.springbootbasic.enu;


public enum MemStatus {

    ACTIVE("Active"),
    INACTIVE("Inactive"),
    SUSPENDED("Suspended"),
    PENDING_APPROVAL("Pending Approval");

    MemStatus(String status) {
    }
}
