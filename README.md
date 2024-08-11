# Application de Gestion des Clients !

Cette application de gestion des clients est construite en utilisant **Spring Boot**, **Vaadin**, et **Java 21**. Elle utilise une base de données **H2** intégrée pour le stockage des données. Ce guide vous expliquera comment configurer et exécuter l'application localement, ainsi que comment la dockeriser pour une exécution plus simple et plus portable.


## Prérequis
Avant de commencer, assurez-vous que les outils suivants sont installés sur votre système :

### 1- Java 21 (JDK)
-   L'application est construite avec Java 21, vous devez donc avoir le JDK 21 installé.
-   Vous pouvez télécharger la dernière version du JDK à partir de OpenJDK ou [Oracle JDK](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html).

Pour vérifier que Java est correctement installé, exécutez :
```
java --version
```


### 2- Apache Maven
-   Maven est utilisé pour gérer les dépendances et construire le projet. Assurez-vous que Maven est installé sur votre machine.
-   Vous pouvez télécharger Maven depuis le site officiel : [Maven Download](https://maven.apache.org/download.cgi).

Pour vérifier l'installation de Maven, exécutez :
```
mvn --version
```

### 3- Docker
   -   Docker est nécessaire pour exécuter l'application dans un conteneur.
   -   Installez Docker Desktop à partir de Docker.

### 4- Docker Compose
   -   Docker Compose est utilisé pour orchestrer les conteneurs Docker.
   -   Docker Compose est généralement inclus avec Docker Desktop.

## Installation et Configuration

### 1. Cloner le dépôt
Clonez le dépôt GitHub du projet sur votre machine locale :
```
git clone https://github.com/votre-utilisateur/gestion-des-clients.git 
cd gestion-des-clients
```

### 2. Construire le projet

Avant de pouvoir exécuter l'application, vous devez la compiler en utilisant Maven. Cette étape téléchargera toutes les dépendances nécessaires et construira un fichier JAR.

```
mvn clean package
```


### 3. Exécuter l'application localement

Si vous souhaitez exécuter l'application sans Docker, vous pouvez le faire directement via Maven :

```
mvn spring-boot:run
```
Accédez à l'application dans votre navigateur à l'adresse suivante : http://localhost:8009

### 4. Dockeriser l'application

#### 4.1 Construire l'image Docker

Si vous préférez exécuter l'application dans un conteneur Docker, commencez par construire l'image Docker :

```
docker-compose build
```

#### 4.2 Démarrer les conteneurs

Ensuite, démarrez les conteneurs Docker :
```
docker-compose up
```

Cela démarre l'application dans un conteneur Docker. Vous pouvez accéder à l'application à l'adresse : http://localhost:8009

### 5. Arrêter les conteneurs

Pour arrêter l'application et les conteneurs Docker, exécutez :
```
docker-compose down
```

# Structure du Projet

-   `src/main/java` : Contient le code source de l'application.
-   `src/main/resources` : Contient les fichiers de configuration, comme `application.properties`.
-   `Dockerfile` : Fichier de configuration pour Docker.
-   `docker-compose.yml` : Fichier de configuration pour Docker Compose.
-   `target/` : Dossier où le fichier JAR est généré après la construction.

## Configurations supplémentaires

### Profil de développement

L'application est configurée pour utiliser un profil Spring Boot `dev` par défaut. Si vous souhaitez modifier cela, vous pouvez le faire en ajustant les propriétés Spring dans les fichiers de configuration ou en changeant la variable d'environnement `SPRING_PROFILES_ACTIVE`.

## Contribution

Les contributions sont les bienvenues ! Si vous trouvez des bugs ou avez des suggestions pour améliorer l'application, veuillez soumettre un problème ou une demande de tirage (pull request).

> **Auteur:** Solo Soaniaina  *Aout 2024*
