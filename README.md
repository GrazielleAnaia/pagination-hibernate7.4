Production-Ready Code | Backend
Java · Spring Boot · Hibernate · PostgreSQL
I break backend code on purpose, read the SQL it really sends, and fix it the way it should run in production.

 

What I work on
Most backend tutorials stop at "it works on my machine". My videos start where those stop:

What the ORM actually sends. Every video shows the generated SQL, not just the Java.
Failures that only show up at scale. In-memory pagination, N+1 queries, lazy-loading traps, connection-pool exhaustion.
Guardrails, not just fixes. Settings and tests that make a bad query fail in CI instead of in production.
Live, reproducible demos. Every repository runs with docker compose up and one Maven command.
Latest video
JOIN FETCH Pagination Still Loads Every Row Into RAM (Hibernate 7.4) Hibernate 7.4 fixed HHH90003004 for simple JOIN FETCH + Pageable queries. One filter on the child collection brings in-memory pagination back. The video covers a fail-fast guardrail and the Two-Query ID pattern that fixes it.

▶ Watch on YouTube · 💻 https://youtu.be/resdV3GH9-M

Video repositories
Topic	What it shows	Code
Hibernate 7.4 pagination	JOIN FETCH + Pageable, HHH90003004, Two-Query ID pattern	repo
Next video	Coming soon	
Each repository follows the same layout:

docker compose up -d       # PostgreSQL
./mvnw spring-boot:run     # the app (Windows: .\mvnw spring-boot:run)
Tech I use in the videos
 
 
 
 
 
 

Suggest a topic
Hit a backend bug that only showed up in production? Open an issue or leave a comment on the latest video. The best ones become episodes.

