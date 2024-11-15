# Gestione Utenti application

# Run
From terminal access 'docker' directory and run "docker compose" command to build and run app and db containers.

# API
The application api is exposed at 8080 port, the communication is performed through HTTP protocol.

To test it you can perform requests like:

- GET http://127.0.0.1:8080/ -> per ottenere la lista degli utenti con i loro ruoli
- GET http://127.0.0.1:8080/{id} -> per ottenere un utente con il suo ruolo
- POST http://127.0.0.1:8080/ -> per aggiungere un utente con uno o più ruoli
- PUT http://127.0.0.1:8080/{id} -> per modificare l'utente
- DELETE http://127.0.0.1:8080/{id} -> per cancellare l'utente