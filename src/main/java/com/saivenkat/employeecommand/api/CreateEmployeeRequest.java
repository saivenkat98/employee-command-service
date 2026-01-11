package com.saivenkat.employeecommand.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

public record CreateEmployeeRequest(
    @NotBlank String name,
    @NotBlank String department,
    @Email @NotBlank String email
) {
    
}
