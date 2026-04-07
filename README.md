<p align="center">
   <img src="./front/src/favicon.png" width="192px" />
</p>

# MicroCRM (P7 - Développeur Full-Stack - Java et Angular - Mettez en œuvre l'intégration et le déploiement continu d'une application Full-Stack)

MicroCRM est une application de démonstration basique ayant pour être objectif de servir de socle pour le module "P7 - Développeur Full-Stack".

L'application MicroCRM est une implémentation simplifiée d'un ["CRM" (Customer Relationship Management)](https://fr.wikipedia.org/wiki/Gestion_de_la_relation_client). Les fonctionnalités sont limitées à la création, édition et la visualisations des individus liés à des organisations.

![Page d'accueil](./misc/screenshots/screenshot_1.png)
![Édition de la fiche d'un individu](./misc/screenshots/screenshot_2.png)

## Code source

### Organisation

Ce [monorepo](https://en.wikipedia.org/wiki/Monorepo) contient les 2 composantes du projet "MicroCRM":

- La partie serveur (ou "backend"), en Java SpringBoot 3;
- La partie cliente (ou "frontend"), en Angular 17.

### Démarrer avec les sources

#### Serveur

##### Dépendances

- [OpenJDK >= 17](https://openjdk.org/)

##### Procédure

1. Se positionner dans le répertoire `back` avec une invite de commande:

   ```shell
   cd back
   ```

2. Construire le JAR:

   ```shell
   # Sur Linux
   ./gradlew build

   # Sur Windows
   gradlew.bat build
   ```

3. Démarrer le service:

   ```shell
   java -jar build/libs/microcrm-0.0.1-SNAPSHOT.jar
   ```

Puis ouvrir l'URL http://localhost:8080 dans votre navigateur.

#### Client

##### Dépendances

- [NPM >= 10.2.4](https://www.npmjs.com/)

##### Procédure

1. Se positionner dans le répertoire `front` avec une invite de commande:

   ```shell
   cd front
   ```

2. (La première fois seulement) Installer les dépendances NodeJS:

   ```shell
   npm install
   ```

3. Démarrer le service de développement:

   ```shell
   npx @angular/cli serve
   ```

Puis ouvrir l'URL http://localhost:4200 dans votre navigateur.

### Exécution des tests

#### Client

**Dépendances**

- Google Chrome ou Chromium

Dans votre terminal:

```shell
cd front
CHROME_BIN=</path/to/google/chrome> npm test
```

#### Serveur

Dans votre terminal:

```shell
cd back
./gradlew test
```

### Images Docker

#### Client

##### Construire l'image

```shell
docker build --target front -t orion-microcrm-front:latest .
```

##### Exécuter l'image

```shell
docker run -it --rm -p 80:80 -p 443:443 orion-microcrm-front:latest
```

L'application sera disponible sur https://localhost.

#### Serveur

##### Construire l'image

```shell
docker build --target back -t orion-microcrm-back:latest .
```

##### Exécuter l'image

```shell
docker run -it --rm -p 8080:8080 orion-microcrm-back:latest
```

L'API sera disponible sur http://localhost:8080.

#### Tout en un

```shell
docker build --target standalone -t orion-microcrm-standalone:latest .
```

##### Exécuter l'image

```shell
docker run -it --rm -p 8080:8080 -p 80:80 -p 443:443 orion-microcrm-standalone:latest
```

L'application sera disponible sur https://localhost et l'API sur http://localhost:8080.

#### Docker Compose

Lancer l'application complète (backend + frontend) en une commande :

```shell
docker compose up -d
```

Le frontend attend que le backend soit healthy avant de démarrer. L'application est accessible sur http://localhost (frontend) et http://localhost:8080 (API).

---

## Industrialisation CI/CD

### Choix techniques

| Composant | Outil | Justification |
| --- | --- | --- |
| CI/CD | GitHub Actions | Intégré nativement à GitHub, gratuit pour les repos publics, large écosystème d'actions |
| Qualité de code | SonarQube Cloud | Analyse statique (vulnérabilités, code smells, couverture), Quality Gate bloquant sur les PR |
| Versioning | semantic-release | Versioning SemVer automatique basé sur les Conventional Commits (`feat:`, `fix:`, `feat!:`) |
| Registry Docker | GitHub Container Registry (GHCR) | Intégré à GitHub, authentification via `GITHUB_TOKEN`, images liées au repository |
| Scan de sécurité | Trivy | Scan des vulnérabilités des images Docker (mode informatif) |
| Couverture backend | JaCoCo | Standard Java, intégré à Gradle, rapports exploitables par SonarQube |
| Monitoring | ELK (Elasticsearch, Logstash, Kibana) | Centralisation et visualisation des logs applicatifs (backend + frontend) |
| Serveur web frontend | Caddy | Image officielle alpine, HTTPS automatique, gzip, routing SPA natif |
| JDK production | Eclipse Temurin 17 | Distribution Adoptium officielle, JRE seul (image minimale) |

### Pipeline CI/CD

Deux workflows GitHub Actions complémentaires :

1. **CI/CD** (`ci.yml`) - sur PR vers `main` et push sur `main` :
   - Build et tests backend (Gradle + JUnit 5 + JaCoCo)
   - Build et tests frontend (Angular + Karma/ChromeHeadless)
   - Analyse SonarQube (Quality Gate)
   - Publication des images Docker sur GHCR (push `main` uniquement)

2. **Release** (`release.yml`) - après succès de la CI sur `main` :
   - Versioning automatique via semantic-release
   - Création de la release GitHub avec artefacts (JAR + archive Angular)
   - Retag des images Docker avec la version semver

### Monitoring ELK

Lancer la stack de monitoring :

```shell
docker compose -f docker-compose-elk.yml up -d
```

- **Kibana** : http://localhost:5601 (dashboard `MicroCRM Monitoring`)
- **Elasticsearch** : http://localhost:9200
- Logs backend (Spring Boot) et frontend (Caddy) centralisés via Logstash

### Secrets requis

| Secret | Configuration |
| --- | --- |
| `SONAR_TOKEN` | GitHub Settings > Secrets > Actions |
| `GITHUB_TOKEN` | Fourni automatiquement par GitHub Actions |
