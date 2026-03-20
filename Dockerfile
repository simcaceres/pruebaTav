FROM nginx:alpine
COPY . /usr/share/nginx/html


FROM nginx:alpine


LABEL maintainer="sim.caceres@duocuc.cl"
LABEL version="1.0"
LABEL description="Mi primer entorno operativo en Render"


WORKDIR /usr/share/nginx/html


COPY . .

EXPOSE 80


CMD ["nginx", "-g", "daemon off;"]