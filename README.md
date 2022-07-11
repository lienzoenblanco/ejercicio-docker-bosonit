docker network create mynetwork
docker run --network mynetwork --name postgres_test -ePOSTGRES_USER=postgres -e POSTGRES_PASSWORD=contrasena -e POSTGRES_DB=test postgres
docker build -t app .
docker run app --network mynetwork 
