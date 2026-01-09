# SportDigitalWorld
Spring Boot project that manage & provide the Api for booking of slots for sports at mutiple venues.


# SportDigitalWorld – Sports Venue Booking Backend

## Overview

SportDigitalWorld is a **Spring Boot backend application** that simulates a real-world **sports ground / turf booking system**.
It allows managing sports venues, defining time slots, checking availability, and safely booking or cancelling slots.

The project is fully dockerized, so anyone can run it on their machine without installing MySQL or Java locally.

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL 8
* Docker & Docker Compose
* REST APIs (No UI)

---

## Key Features

* Venue management (create, list, delete).
* Slot management with (no overlapping slots) per venue.
* Availability check based on sport and time range.
* Safe booking with (no double booking) (transaction + locking)
* Booking cancellation frees the slot immediately

---

## Sports Constraint 

Sports are (not hardcoded) I have taken them from the below public API provided
GET https://stapubox.com/sportslist/


The sports are loaded everytimefrom this public API when the project starts.

---

## Assumptions

* One booking = one slot
* Slot time cannot be changed once booked
* Cancelled booking makes the slot available immediately
* Single MySQL instance

---

## How to Run the Project (Docker – Recommended Way)

### Prerequisites

* Docker
* Docker Compose
No need to install Java or Maven on your system.

---

### Steps to Run

```bash
git clone https://github.com/exponential-Vijay/SportDigitalWorld.git
cd SportDigitalWorld
docker-compose up --build
```

Docker will:

* Build the Spring Boot JAR inside the container
* Start MySQL automatically
* Start the application

The application will be available at:

```
http://localhost:8080
```

---

## API Endpoints

### Venue APIs

| Method | Endpoint     | Description     |
| ------ | ------------ | --------------- |
| POST   | /venues      | Creates a venue  |
| GET    | /venues      | List all venues |
| DELETE | /venues/{id} | Delete a venue  |

---

### Slot APIs

| Method | Endpoint                | Description                            |
| ------ | ----------------------- | --------------------                   |
| POST   | /venues/{venueId}/slots | Add slots to a venue for the time range|

---

### Availability API

| Method | Endpoint          | Description                                   |
| ------ | ----------------- | --------------------------------------------- |
| GET    | /venues/available | Get available venues for a sport & time range |

Example:
/venues/available?sportCode=7031809&startTime=2026-01-10T10:00&endTime=2026-01-10T12:00


---

### Booking APIs

| Method | Endpoint              | Description    |
| ------ | --------------------- | -------------- |
| POST   | /bookings             | Book a slot    |
| PUT    | /bookings/{id}/cancel | Cancel booking |

---

## Sample Requests

### Create Venue

```json
POST /venues
{
  "name": "Noida sector 73",
  "sportCode": "7031809"
}
```

---

### Book Slot

```json
POST /bookings
{
  "slotId": 5
}
```

---

## Data Safety & Concurrency Handling

* Uses **@Transactional** service methods
* Uses **PESSIMISTIC_WRITE locking** on slots
* Database-level constraints to avoid duplicates

This ensures **no double booking**, even under concurrent requests.

---

## Stopping the Application

```bash
docker-compose down
```

To remove database data completely:

```bash
docker-compose down -v
```

## Author

@Vijay Yadav
mail id : vijay.yadav680@gmail.com
Software Engineer @Novel Patterns Pvt. Ltd.

---

Thank you for reviewing this project 🙏
