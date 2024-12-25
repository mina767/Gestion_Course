# Utiliser l'image officielle de Java comme base (OpenJDK 17 dans cet exemple)
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR compilé depuis le dossier target de votre projet local
COPY target/Gestion_Panier-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port 8080, qui est généralement utilisé pour les applications Spring Boot
EXPOSE 8080

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
