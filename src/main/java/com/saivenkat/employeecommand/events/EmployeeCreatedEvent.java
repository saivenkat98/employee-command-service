package com.saivenkat.employeecommand.events;

public record EmployeeCreatedEvent(
    String eventId,
    String employeeId,
    String name,
    String department,
    String email,
    long occurredAtEpochMs,
    int version
) {
}