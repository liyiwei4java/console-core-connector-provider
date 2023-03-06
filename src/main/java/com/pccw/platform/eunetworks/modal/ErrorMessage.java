package com.pccw.platform.eunetworks.modal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
    private String reason;
    private String message;
    private String code;
}