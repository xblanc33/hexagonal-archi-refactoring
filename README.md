# Vers une archictecture hexagonale : refactoring de code

Cet exercice vise à effectuer un refactoring des classes Player et PlayerDB vers une architecture hexagonale.

L'objectif est de faire en sorte que le test AppTest.java puisse être exécuté sans qu'aucune connection à une base de données soit nécessaire.

## Player

Dans quelle couche de l'architecture hexagonale cette classe se situe-t-elle ?
* domain
* application
* ui
* infra

Quel est le pattern tactique de cette classe ?
* Value Object
* Entity
* Aggregate
* Repository

Construisez le package correspondant et placez y cette classe.

## PlayerDB (sans cache et sans base de données)

Sans considérer le cache mis en place dans cette classe, quel est son pattern tactique ?
* Value Object
* Entity
* Aggregate
* Repository

Mettez en oeuvre ce pattern et placez le dans la couche correspondante

## PlayerDB (avec une base de données InMemory)

Dans quelle couche serait une implémentation InMemory de PlayerDB ?
* domain
* application
* ui
* infra

Mettez en oeuvre cette implémentation

## AppTest 

Modifiez le test afin qu'il puisse être exécuté sans connexion à une base de données.

## PlayerDB (avec une base de donnée JDBC)

Dans quelle couche serait une implémentation JDBC de PlayerDB ?
* domain
* application
* ui
* infra

Mettez en oeuvre cette implémentation

## PlayerDB (avec cache)

Dans quelle couche serait le cache de PlayerDB ?
* domain
* application
* ui
* infra

Mettez en oeuvre cette implémentation

## AppTest avec cache

Ajouter des tests pour tester le cache
