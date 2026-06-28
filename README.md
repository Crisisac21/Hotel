# Hotel Reservas Backend

Backend API for a hotel reservation system built with Spring Boot, Spring Data JPA, and H2 in-memory database.

## Endpoints

- `GET /api/status` - application health status
- `GET /api/clientes` - list clients
- `GET /api/habitaciones` - list rooms
- `GET /api/habitaciones/available` - list available rooms
- `GET /api/reservas` - list reservations
- `GET /api/facturas` - list invoices
- `GET /api/pagos` - list payments
- `GET /api/reportes/resumen` - summary report
- `GET /` - redirects to Swagger UI

## Local Run

```bash
git clone https://github.com/Crisisac21/Hotel.git
cd Hotel
mvn spring-boot:run
```

Open Swagger UI at `http://localhost:8080/swagger-ui.html`.

