# ──────────────────────────────────────────────
# Stage 1 : Build du frontend Angular
# ──────────────────────────────────────────────
FROM node:20-alpine AS front-build

WORKDIR /src

COPY ./front/package.json ./front/package-lock.json ./

RUN npm ci

COPY ./front .

RUN npx @angular/cli build --configuration production

# ──────────────────────────────────────────────
# Stage 2 : Build du backend Spring Boot
# ──────────────────────────────────────────────
FROM gradle:8-jdk17 AS back-build

WORKDIR /src

COPY ./back .

RUN chmod +x gradlew && ./gradlew build -x test

# ──────────────────────────────────────────────
# Stage 3 : Image de production frontend (Caddy)
# ──────────────────────────────────────────────
FROM caddy:2-alpine AS front

COPY --from=front-build /src/dist/microcrm/browser /app/front
COPY misc/docker/Caddyfile /etc/caddy/Caddyfile

EXPOSE 80
EXPOSE 443

USER nobody

# ──────────────────────────────────────────────
# Stage 4 : Image de production backend (Temurin)
# ──────────────────────────────────────────────
FROM eclipse-temurin:17-jre-jammy AS back

RUN groupadd -r appgroup && useradd -r -g appgroup appuser

WORKDIR /app

COPY --from=back-build /src/build/libs/microcrm-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

USER appuser

CMD ["java", "-jar", "app.jar"]
