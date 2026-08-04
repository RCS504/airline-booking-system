# Airline Booking System

A console-based airline booking system built in Java as a personal portfolio project to strengthen software engineering fundamentals through independent design, implementation, and debugging.

The system models a simplified airline booking environment: users can search for flights, view seat availability, reserve seats, cancel bookings, look up and manage bookings, and (as an administrator) add new flights — all through a structured booking engine.

---

## Development Philosophy

This project was built as a learning exercise with the goal of strengthening software engineering and problem-solving skills.

The focus was on independently designing, implementing, testing, and debugging each feature. External resources, including documentation and AI tools, were used for learning, clarification, and debugging guidance rather than generating the project's implementation.

The objective was to develop a deeper understanding of Java, object-oriented programming, software architecture, and the problem-solving process involved in building complete applications.

---

## Features

The system supports:

- Viewing available routes
- Flight searching by origin, destination, and date
- Seat availability viewing (full seat map per flight)
- Passenger bookings with a generated unique booking reference
- Seat reservations, guarded against double-booking
- Booking cancellation, guarded against cancelling an already-cancelled booking
- Booking lookup using unique booking references
- Admin: viewing all bookings for a given flight
- Admin: adding new flights from existing seeded airports and aircraft
- Console-based user interaction, with input validation throughout — malformed numbers, dates, and menu choices are caught and re-prompted rather than crashing the program

---

## Project Structure

```text
src/
├── model/
│   ├── Airport.java
│   ├── Aircraft.java
│   ├── Flight.java
│   ├── Seat.java
│   ├── Passenger.java
│   ├── FrequentFlyerPassenger.java
│   ├── Booking.java
│   └── enums/
│       ├── SeatClass.java
│       ├── SeatStatus.java
│       ├── BookingStatus.java
│       └── LoyaltyTier.java
│
├── system/
│   └── BookingSystem.java
│
└── ui/
    └── Main.java
```

Menu handling ended up living directly in `Main.java` rather than a separate `ConsoleMenu` class — the menu loop and its handler methods were small enough that splitting them out didn't add clarity.

---

## Architecture

The project is designed around a layered architecture that separates domain models, business logic, and user interaction.

### `model`

Contains the core domain classes representing the airline system, including airports, aircraft, flights, passengers, bookings, seats, and related enums.

### `system`

Contains the booking engine responsible for managing flights, reservations, searches, booking references, and core business logic.

### `ui`

Contains the console interface responsible for user interaction, menus, and input handling. Business logic is kept outside this layer to maintain separation of concerns.

This structure allows the booking engine to remain independent from the user interface and makes the system easier to maintain and extend.

---

## Technologies

- Java
- Object-Oriented Programming (OOP)
- Java Collections (`ArrayList`, `HashMap`)
- Java Time API (`LocalDateTime`)
- No external libraries in the core system

---

## Design Principles

The project was built with an emphasis on:

- Object-oriented design
- Separation of concerns
- Modular architecture
- Maintainable code
- Reusable business logic
- Robust input validation
- Incremental development through small, testable changes

---

## Progress

- [x] Project planning
- [x] Repository setup
- [x] Package structure
- [x] Initial documentation
- [x] Domain model implementation
- [x] Booking engine implementation
- [x] Flight search functionality
- [x] Seat map generation
- [x] Seat reservation system
- [x] Booking cancellation
- [x] Booking lookup
- [x] Admin: view all bookings for a flight
- [x] Admin: add flight
- [x] Console interface
- [x] Input validation / robustness pass
- [ ] Data persistence (out of scope for v1 — see below)

---

## Out of Scope (v1)

Deliberately left out to keep the focus on core logic rather than breadth of features:

- **Waitlist / priority-queue behaviour** — the `FrequentFlyerPassenger`/`LoyaltyTier` model exists, but isn't wired into any priority logic yet
- **Persistent storage** — state is in-memory only for the current run
- **A Console-class (colour/graphics) visual reskin**
- **Any client-server split**

## AI Usage

AI (Claude) was used throughout as a debugging aid — pointing at the location and shape of bugs (e.g. Scanner buffer/newline issues, variable scope, missing null/empty-list guards) without providing fixes or code directly — and to help update this README. All implementation was designed, written, and debugged independently.

---

## Status

**v1 complete.** All core functionality — flight search, seat maps, booking, cancellation, lookup, and admin management — is implemented, tested, and validated against malformed input.