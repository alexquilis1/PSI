# import json
# import requests
# from lxml import html



# resultado = requests.get("http://sendasdemadrid.es/temas/index.php?tematica=1")

# tree = html.fromstring(resultado.text)
# rutas = tree.xpath('//a[@rel="ampliaficha"]/@href')

# datos = []

# for ruta in rutas:
#     id = ruta.split("=")[1]
#     ruta_res = requests.get("http://sendasdemadrid.es/sendas/index.php?senda="+str(id))
#     tree_ruta = html.fromstring(ruta_res.text)
#     nombre = tree_ruta.xpath('//h1[@class="titulo_ruta"]/text()')
#     print(nombre[0])
#     tabla = tree_ruta.xpath('//div[@class="datos_texto datos_texto_tipo"]/p/text()')
#     print(tabla)
#     print("dificultad", tabla[0])
#     datos.append({"id": id, 'nombre': nombre[0], "dificultad": tabla[0].strip(), "inicio": tabla[2].strip(), "final": tabla[3].strip(), "señalizacion": tabla[4].strip(), "longitud": tabla[6].strip(), "cota_max": tabla[7].strip(), "cota_min": tabla[8].strip()})
#     print()



# with open('output.json', 'w', encoding="utf-8") as f:
#     json.dump(datos, f)







import mysql.connector
import json


cnx = mysql.connector.connect(user='root', password='root',
                              host='localhost',
                              database='db')
cursor = cnx.cursor()


datos = []
with open('output.json', 'r', encoding="utf-8") as f:
    datos = json.load(f)

sql = "INSERT INTO senda (id, nombre, dificultad, inicio, final, señales, longitud, cota_max, cota_min) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s)"
val = [(x["id"], x["nombre"], x["dificultad"], x["inicio"], x["final"], x["señalizacion"], x["longitud"], x["cota_max"], x["cota_min"]) for x in datos]
  
cursor.executemany(sql, val)
cnx.commit()
cnx.close()


