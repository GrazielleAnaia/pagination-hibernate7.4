<h1 align="center">Production-Ready Code | Backend</h1>

<p align="center">
  <b>Java · Spring Boot · Hibernate · PostgreSQL</b><br>
  I break backend code on purpose, read the SQL it really sends, and fix it the way it should run in production.
</p>

<p align="center">
  <a href="https://www.youtube.com/@ProdReadyCodeBackend"><img src="https://img.shields.io/badge/YouTube-Production--Ready%20Code-FF0000?style=for-the-badge&logo=youtube&logoColor=white" alt="YouTube channel"></a>
  <a href="https://www.linkedin.com/in/grazielle-anaia/"><img src="https://img.shields.io/badge/LinkedIn-Connect-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn"></a>
</p>

---

## What I work on

Most backend tutorials stop at "it works on my machine". My videos start where those stop:

- **What the ORM actually sends.** Every video shows the generated SQL, not just the Java.
- **Failures that only show up at scale.** In-memory pagination, N+1 queries, lazy-loading traps, connection-pool exhaustion.
- **Guardrails, not just fixes.** Settings and tests that make a bad query fail in CI instead of in production.
- **Live, reproducible demos.** Every repository runs with `docker compose up` and one Maven command.

## Latest video

**JOIN FETCH Pagination Still Loads Every Row Into RAM (Hibernate 7.4)**
Hibernate 7.4 fixed `HHH90003004` for simple `JOIN FETCH` + `Pageable` queries. One filter on the child collection brings in-memory pagination back. The video covers a fail-fast guardrail and the Two-Query ID pattern that fixes it.

▶ [Watch on YouTube](https://youtu.be/resdV3GH9-M) · 💻 [Source code](https://github.com/GrazielleAnaia/pagination-hibernate7.4)

## Video repositories

| Topic | What it shows | Code |
|---|---|---|
| Hibernate 7.4 pagination | `JOIN FETCH` + `Pageable`, `HHH90003004`, Two-Query ID pattern | [repo](https://github.com/YOUR-USERNAME/YOUR-REPO) |
| *Next video* | *Coming soon* | |

Each repository follows the same layout:

```
docker compose up -d       # PostgreSQL
./mvnw spring-boot:run     # the app (Windows: .\mvnw spring-boot:run)
```

## Tech I use in the videos

![Java](https://img.shields.io/badge/Java%2025-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot%204-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate%207-59666C?style=flat-square&logo=hibernate&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=flat-square&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=docker&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apachemaven&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=flat-square&logo=intellijidea&logoColor=white)
