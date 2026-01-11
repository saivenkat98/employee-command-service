package com.saivenkat.employeecommand.events;

import java.time.Instant;

public record EmployeeCreatedEvent(
    String eventId,
    String employeeId,
    String name,
    String department,
    String email,
    Instant occurredAt,
    int version
) {
}