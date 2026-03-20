FROM nginx:alpine
COPY . /usr/share/nginx/html

# 1. Usamos una versión ligera y segura de Nginx
FROM nginx:alpine

# 2. Etiquetamos el proyecto (esto se ve en Docker Hub)
LABEL maintainer="sim.caceres@duocuc.cl"
LABEL version="1.0"
LABEL description="Mi primer entorno operativo en Render"

# 3. Directorio de trabajo dentro del contenedor
WORKDIR /usr/share/nginx/html

# 4. Copiamos los archivos de tu carpeta local al servidor
# El punto '.' indica que copia TODO lo que tienes en VS Code
COPY . .

# 5. Exponemos el puerto 80 (el estándar para web)
EXPOSE 80

# 6. Comando para que el servidor no se apague nunca
CMD ["nginx", "-g", "daemon off;"]