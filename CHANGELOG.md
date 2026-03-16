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
