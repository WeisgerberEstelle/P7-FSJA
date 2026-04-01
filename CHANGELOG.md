# [1.3.0](https://github.com/WeisgerberEstelle/P7-FSJA/compare/v1.2.0...v1.3.0) (2026-04-01)


### Bug Fixes

* **ci:** ajouter la permission actions:read pour le téléchargement des artifacts cross-workflow ([750427b](https://github.com/WeisgerberEstelle/P7-FSJA/commit/750427b0645dd2be83027063aa7eee34a13affd7))
* **ci:** améliorer la pipeline CI/CD ([2c512e6](https://github.com/WeisgerberEstelle/P7-FSJA/commit/2c512e6e34a6ea2d66ee167997da513d41d75bdd))
* **ci:** améliorer la pipeline CI/CD ([ee0fbfb](https://github.com/WeisgerberEstelle/P7-FSJA/commit/ee0fbfb7336cff63042b803a8420302ca92120b6))
* **ci:** corriger la copie du JAR en excluant le fichier plain.jar ([1cc6075](https://github.com/WeisgerberEstelle/P7-FSJA/commit/1cc607540190d23de283ddbf1ea453efb83a0463))
* **ci:** filtrer les push sur la branche main uniquement ([4ad3def](https://github.com/WeisgerberEstelle/P7-FSJA/commit/4ad3def52f05a9b620d8b232e8981db05c184801))
* **ci:** mettre à jour sonarqube-quality-gate-action v1 vers v4 ([bb61310](https://github.com/WeisgerberEstelle/P7-FSJA/commit/bb61310fa489253855d111cea3994b6e709a1859))
* **ci:** passer Trivy en mode informatif (exit-code 0) ([810aae2](https://github.com/WeisgerberEstelle/P7-FSJA/commit/810aae22af2b1810bd3a02e854ed2ec4d283cb7c))
* **ci:** revenir à sonarqube-quality-gate-action v1 (v4 inexistante) ([fdc9b25](https://github.com/WeisgerberEstelle/P7-FSJA/commit/fdc9b25418a4fe827f11a76a136f7a3240ee9e7a))
* **deps:** mettre à jour Spring Boot 3.2.5 vers 3.4.5 ([85a5016](https://github.com/WeisgerberEstelle/P7-FSJA/commit/85a501612c796379af64432052823d22524459ec))
* **docker:** utiliser un glob pour le nom du JAR dans le Dockerfile ([1a8f600](https://github.com/WeisgerberEstelle/P7-FSJA/commit/1a8f600f52c7539ac826dc9f0a462d36a6b25797))


### Features

* **ci:** déclencher le pipeline CI sur push de toutes les branches ([d574e33](https://github.com/WeisgerberEstelle/P7-FSJA/commit/d574e3397a3d7618fbd5ead5942fbff1176ab3d4))
* **monitoring:** mettre en place la stack ELK pour le monitoring applicatif ([f12b358](https://github.com/WeisgerberEstelle/P7-FSJA/commit/f12b358631634b99092ab8a65c7e14a81f287c8b))


### Performance Improvements

* **ci:** réutiliser les artifacts CI dans le workflow release ([5dda4df](https://github.com/WeisgerberEstelle/P7-FSJA/commit/5dda4df2ed499d50258f3ad7ae0d7c4bfcaa1ab7))

# [1.2.0](https://github.com/WeisgerberEstelle/P7-FSJA/compare/v1.1.0...v1.2.0) (2026-03-16)


### Features

* mise à jour automatique des versions dans build.gradle et package.json ([a3bbb92](https://github.com/WeisgerberEstelle/P7-FSJA/commit/a3bbb9238cb447e181aba164630a1a6f0087408c))

# [1.1.0](https://github.com/WeisgerberEstelle/P7-FSJA/compare/v1.0.0...v1.1.0) (2026-03-16)


### Bug Fixes

* release attend que la CI soit passée avant de se lancer ([e5c3805](https://github.com/WeisgerberEstelle/P7-FSJA/commit/e5c3805dcf11c12194864d6bfe1fff2c95791cb9))


### Features

* retag images Docker avec la version semver après release ([b25bee8](https://github.com/WeisgerberEstelle/P7-FSJA/commit/b25bee8d2c7fb98f2a8feb53a06244a9af1525cf))

# 1.0.0 (2026-03-16)


### Bug Fixes

* **cd:** convertir le nom du repo en lowercase pour les tags GHCR ([5c82e8b](https://github.com/WeisgerberEstelle/P7-FSJA/commit/5c82e8b9251e52ab9c6d85e8f59f085ce0ccb3af))
* **ci:** limiter le push au branch main pour éviter les runs en double ([53edea1](https://github.com/WeisgerberEstelle/P7-FSJA/commit/53edea1088d0018ab2134881c761d905c7d4772d))
* **ci:** upload classes compilées backend pour SonarQube ([cc591f4](https://github.com/WeisgerberEstelle/P7-FSJA/commit/cc591f4887d92fb5c57db4f6098b7d5f95a48ddd))
* **docker:** écoute sur port 80 uniquement dans Caddyfile ([828ad68](https://github.com/WeisgerberEstelle/P7-FSJA/commit/828ad68a896eaa1e6333b91dab9f06f65cd694a1))


### Features

* ajout docker-compose.yml avec healthcheck et depends_on ([0f8718a](https://github.com/WeisgerberEstelle/P7-FSJA/commit/0f8718ade287e7f20f4d0be8c5647b99ddb41f96))
* ajout workflow release automatique sur tag vX.Y.Z ([f964f15](https://github.com/WeisgerberEstelle/P7-FSJA/commit/f964f1584063f47ef6285816d9b5b3af88927e11))
* **cd:** publication des images Docker sur GHCR au merge sur main ([ee57cde](https://github.com/WeisgerberEstelle/P7-FSJA/commit/ee57cde8d125f3b3cf4a3f88959d14b0fefbf139))
* remplacer workflow release par semantic-release ([e7d4648](https://github.com/WeisgerberEstelle/P7-FSJA/commit/e7d4648aed3ade3290c6feef4b69e7a47a8cc5a8))
