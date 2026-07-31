# Airline Booking System

A console-based airline booking system being developed in Java as a personal portfolio project to strengthen software engineering fundamentals through independent design, implementation, and debugging.

The project aims to model a simplified airline booking environment where users can search for flights, view seat availability, reserve seats, cancel bookings, and manage bookings through a structured booking engine.

---

## Development Philosophy

This project is being developed as a learning exercise with the goal of strengthening software engineering and problem-solving skills.

The focus is on independently designing, implementing, testing, and debugging each feature. External resources, including documentation and AI tools, are used for learning, clarification, and debugging guidance rather than generating the project's implementation.

The objective is to develop a deeper understanding of Java, object-oriented programming, software architecture, and the problem-solving process involved in building complete applications.

---

## Planned Features

The completed system is intended to support:

- Airport and flight management
- Aircraft seat generation
- Flight searching
- Seat availability viewing
- Passenger bookings
- Seat reservations
- Booking cancellation
- Booking lookup using unique booking references
- Console-based user interaction
- Administrative flight and booking management

---

## Project Structure

The planned structure is:

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
│
├── system/
│   └── BookingSystem.java
│
└── ui/
    ├── ConsoleMenu.java
    └── Main.java
```

The final structure may change slightly as development progresses.

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

The project is being developed with an emphasis on:

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
- [ ] Domain model implementation
- [ ] Booking engine implementation
- [ ] Flight search functionality
- [ ] Seat map generation
- [ ] Seat reservation system
- [ ] Booking cancellation
- [ ] Booking lookup
- [ ] Console interface
- [ ] Testing and refinement
- [ ] Data persistence

---

## Future Improvements

Possible future enhancements include:

- Persistent storage
- Dynamic ticket pricing
- Passenger database
- Frequent flyer rewards
- Waitlist functionality
- Additional administrative tools
- Improved search and filtering
- Alternative user interfaces

---

## Status

This project is currently in the planning and early development stage.

Features will be implemented incrementally, with progress tracked through regular commits as new functionality is completed and tested.