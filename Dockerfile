FROM nginx:alpine
WORKDIR /usr/share/nginx/html
COPY . .
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]



FROM nginx:alpine

# Etiquetas de información
LABEL maintainer="sim.caceres@duocuc.cl"
LABEL version="1.0"
LABEL description="Mi primer entorno operativo en Render"

# Directorio donde Nginx busca los archivos para mostrar
WORKDIR /usr/share/nginx/html

# Copia tu index.html al contenedor
COPY . .

# Expone el puerto 80
EXPOSE 80

# Ejecuta Nginx
CMD ["nginx", "-g", "daemon off;"]
