package com.developerscambodia.catalog.dto;

import java.time.LocalDateTime;

public record ApiDto<T>(
        String message,
        Integer code,
        Boolean status,
        LocalDateTime timeStamp,
        T data
) {
}
