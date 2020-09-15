# TCC-PUCMinas-18
Travaille de conclusion de cours de la PucMinas, 2018

Requis:
Avoir installé ou disponibles les logiciels suivants : NPM (Node Package Manager); Maven; Java 8; Wildfly 13.

# Compilation et exécution du module web
Entre dans le dossier /logistica-transporte-web-vue.

À la ligne de commande, exécutez la commande $ npm install (pour télécharger et installer les dépendances du projet).

$ npm run dev (pour exécuter le projet).

Accèdez localhost:4200.

Configuration du certificat numérique auto-signé

Dans le dossier certificat/ (git) est le certificat numérique auto-signé, le fichier server.keystore. Le fichier doit être mis en $PATH_WILDFLY13/standalone/configuration/.

Dans le même dossier est le fichier standalone.xml. Il contient les informations pour la configuration du XML pour que le certificat soit reconnu par le serveur.

# Compilation et exécution des modules Java
Les modules qui doivent être déployés sont ModuloSeguranca, ControleCTE e ControleEntregas.

Entrez dans le dossier de chacun des modules et taper $ mvn clean package (les dépendances seront téléchargées e les projets seront compilés).

Les fichiers .war gérés dans le dossier /target de chacun des modules doivent être déployés en $PATH_WILDFLY13/standalone/deployments/.

Ensuite, il faut créer les fichiers vides avec les noms suivants cte.war.dodeploy, entregas.war.dodeploy et seguranca.war.dodeploy.

Pour exécuter le Wildfly, allez dans $PATH_WILDFLY13/bin/ par la ligne de commande. Exécute les fichiers standalone.bat ou standalone.sh.
