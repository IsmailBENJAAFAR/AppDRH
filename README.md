# Gestionnaire de Stagiaires

Ce projet vise à créer une application de gestion des stagiaires, conçue pour être utilisée par différents utilisateurs avec des droits d'accès précis en fonction de leur poste. Les principaux acteurs de l'application sont l'Administrateur DRH et le Chef de la DRH. Chacun de ces acteurs doit s'authentifier (login et mot de passe) pour pouvoir exercer ses fonctions. Le mot de passe peut être enregistré pour faciliter l'accès ultérieur.

## Fonctionnalités Principales

### Authentification
- Les utilisateurs doivent s'authentifier avec un login et un mot de passe.

### Inscription des Stagiaires
- Les stagiaires peuvent s'inscrire en ligne en saisissant leurs informations personnelles.

### Gestion des Stages
- Le cadre peut ajouter un stage au stagiaire, avec des détails tels que le sujet du stage, le nom de l'encadrant, la date de début et de fin du stage, la division, et le type de stage.

### Gestion des Utilisateurs
- Le Chef de la DRH peut ajouter, modifier ou supprimer des stagiaires, des encadrants et des stages.
- L'Administrateur DRH peut identifier un stagiaire ou un encadrant par son nom ou son CIN, et afficher les statistiques des départements.

### Génération d'Attestations
- Les utilisateurs peuvent générer et imprimer des attestations de stage en spécifiant le nom et le prénom du stagiaire. Les attestations contiennent des informations telles que le nom complet du stagiaire et le département où il a effectué son stage.

### Gestion des Comptes Utilisateurs
- L'Administrateur peut ajouter, supprimer et modifier les comptes d'utilisateurs, ainsi que définir leur type (Administrateur DRH, Chef DRH).

## Réalisation

### Fonctionnalités du Chef DRH
1. Authentification
2. Gestion des comptes utilisateurs
3. Gestion des stagiaires
4. Gestion des stages/encadrants
5. Liste des stagiaires
6. Liste des stages/encadrants
7. Recherche des stagiaires
8. Marquer l'absence
9. Impression des attestations
10. Envoi d'emails
11. Affichage des statistiques

### Fonctionnalités de l'Administrateur DRH
1. Authentification
2. Gestion des stagiaires
3. Liste des stagiaires
4. Liste des stages
5. Recherche des stagiaires
6. Marquer l'absence
7. Impression des attestations
8. Affichage des statistiques
9. Envoi d'emails

### Fonctionnalités de l'Administrateur
1. Gestion des comptes utilisateurs
2. Autres fonctionnalités d'un Administrateur DRH et Chef DRH

Ce projet vise à faciliter la gestion des stagiaires, des stages et des encadrants au sein de l'organisation en fournissant une plateforme centralisée et sécurisée pour gérer ces processus de manière efficace.

# Architecture d'Application Java

Ce projet est une démonstration d'une architecture d'application Java basée sur trois projets : un projet web, un projet EJB, et un projet d'application entreprise.

## Projet Web

Le projet web contient la logique de présentation de l'application. Il utilise JavaServer Faces (JSF) comme framework web et PrimeFaces pour les composants UI. Le projet est structuré selon le modèle MVC (Modèle-Vue-Contrôleur) avec des Managed Beans pour gérer la logique métier côté serveur.

### Technologies utilisées :
- JavaServer Faces (JSF)
- PrimeFaces
- Managed Beans

## Projet EJB

Le projet EJB contient la logique métier de l'application. Il utilise des Enterprise JavaBeans (EJB) pour encapsuler les services métier réutilisables. Les EJB sont déployés sur un serveur d'applications Java EE (WildFly) pour bénéficier des fonctionnalités de gestion des transactions, de sécurité, etc.

### Technologies utilisées :
- Enterprise JavaBeans (EJB)
- Java Persistence API (JPA) pour la gestion des entités

## Projet Application Entreprise

Le projet Application Entreprise agit comme une couche d'orchestration et de coordination entre le projet web et le projet EJB. Il contient des classes utilitaires, des services d'infrastructure, des configurations, et des intercepteurs pour gérer les aspects transversaux de l'application.

### Technologies utilisées :
- Contexts and Dependency Injection (CDI) pour l'injection de dépendances
- Autres services et utilitaires Java EE

## Comment exécuter l'application

1. Cloner le dépôt GitHub
2. Importer les trois projets dans votre IDE
3. Configurer et démarrer un serveur d'application Java EE (WildFly, GlassFish, etc.)
4. Déployer les projets web et EJB sur le serveur
5. Accéder à l'application via un navigateur web

Ce projet est une démonstration et peut être étendu pour inclure plus de fonctionnalités et de composants. Pour plus d'informations, consultez la documentation de chaque projet.
