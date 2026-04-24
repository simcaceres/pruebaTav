import os 
import requests
from datetime import datetime
import re 

RUTA_ARCHIVO = "archivoia.txt"

API_URL = os.getenv("API_GATEWAY_URL","http://localhost:8080")

def limpiar_y_transformar(contenido_bruto):
    lineas = contenido_bruto.strip().split('\n')
    datos_limpios = []

    for linea in lineas:
        partes = linea.split('|')

        if len(partes) >= 8:
            item = {
                "cliente": partes[0].replace("cliente:", "").strip(),
                "direccion": partes[1].replace("direccion:","").strip(),
                "telefono": partes[2].replace("telefono:","").strip(),
                "correo": partes[3].replace("correo","").strip().lower(),
                "producto": partes[4].replace("producto","").strip(),
                "cantidad": partes[5].replace("cantidad","").strip(),
                "metodo_pago": partes[6].replace("metodo_pago","").strip().lower(),
                "extra": partes[7].replace("extra","").strip(),
                "estado_proceso": "DATOS_COMPLETOS"
            }
            datos_limpios.append(item)
    return datos_limpios        

def validar_datos(datos):
    metodos_validos = ["efectivo", "targeta"] 

    regex_correo = r'^[\w\.-]+@[\w\.-]+\.\w+$'

    for item in datos:

        campos_criticos = ["cliente", "direccion",  "correo", "producto" ] 

        if any(not item[campo] for campo in campos_criticos):
             print("Error: Faltan datos de contacto del cliente")
             return False
        
        if item["metodo_pago"] not in metodos_validos:
           print(f"Error: Pago '{item["metodo_pago"]}' invalido.")
           return False

        if not re.match(regex_correo, item['correo']):
           print(f"Error: El correo '{item["correo"]}' no tiene formato valido")
           return False
        
    return True

def iniciar_pipeline():
    print(f'[{datetime.now()}] --- Pipeline Logistico APP Yo Invito ---')

    try:
        if not os.path.exists(RUTA_ARCHIVO):
            print(f"Error: No existe el archivo de ingesta.")
            return
            
        with open(RUTA_ARCHIVO, 'r') as f:
                contenido = f.read()

        datos_procesados = limpiar_y_transformar(contenido)

        if validar_datos(datos_procesados):
            payload = {
                "orden": datos_procesados,
                "metadata": {"sistema": "Ingesta_v3", "timestamp": str(datetime.now())}

            }

            print(f"-> Enviando pedido de {datos_procesados[0]['cliente']} al Gateway...")
            res = requests.post(f"{API_URL}/ingesta", json=payload)

            if res.status_code in [200, 201]:
                print("---Exito: Datos de cliente y pedido enviados correctamente---")
            else:
                print(f"Error Gateway: {res.status_code}")
        else:
            print("!!! Fallo en validacion de contacto o pago.")
    except Exception as e:
        print(f"Fallo critico: {e}")                

            

if __name__ == "__main__":
    iniciar_pipeline()