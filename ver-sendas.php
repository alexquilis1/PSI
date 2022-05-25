<?php
$servername = "localhost:3306";
$username = "root";
$password = "root";
$dbname = "db";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Creación variable id
// 2 porq es el primer id de senda que existe
$id = isset($_GET["id"]) ? $_GET["id"] : '2';

$sql = "SELECT id, nombre, dificultad, inicio, final, señales, longitud, cota_max, cota_min FROM senda WHERE id = " . $id;
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while ($row = $result->fetch_assoc()) {
        $id = $row["id"];
        $nombre = $row["nombre"];
        $dificultad = $row["dificultad"];
        $inicio = $row["inicio"];
        $final = $row["final"];
        $señales = $row["señales"];
        $longitud = $row["longitud"];
        $cota_max = $row["cota_max"];
        $cota_min = $row["cota_min"];
    }
} else {
    echo "0 results";
}
?>

<!DOCTYPE html>
<html>

<head lang="en">
    <meta charset="UTF-8">
    <title>
        Traccia
    </title>
    <link rel="stylesheet" href="estilo-html.css">

    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" integrity="sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A==" crossorigin="" />
    <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js" integrity="sha512-XQoYMqMTK8LvdxXYG3nZ448hOEQiglfqkJs1NOQV44cWnUrBc8PkAOcXy20w0vlaXaVUearIOBhiXZ5V3ynxwA==" crossorigin=""></script>

    <!-- Fuente para h1 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Paytone+One&display=swap" rel="stylesheet">

    <!-- Favicon -->
    <link rel="icon" href="logo/tortuga_fav.png" type="image/png">
</head>

<body>

    <!-- Leaflet Omnivore plugin -->
    <script src='//api.tiles.mapbox.com/mapbox.js/plugins/leaflet-omnivore/v0.3.1/leaflet-omnivore.min.js'></script>

    <div class="cabecera">
        <header>
            <h1>
                TRACCIA
            </h1>
            <!-- Menú de navegación del sitio -->
            <div id="navegador">
                <ul>
                    <li><a href="ver-sendas.php">Página principal</a></li>
                    <!-- <li><a href="accesos-tematicos.html">Accesos temáticos</a></li> -->
                    <li><a href="enlaces.html">Enlaces de interés</a></li>
                </ul>
                </nav>
            </div>
        </header>
        <div class="cuerpo">
            <!-- Para probar que funciona de manera correcta -->
            <?= $nombre ?>
            <div id="map"></div>
            <script>
                var map = L.map('map').setView([40.41889, -3.69194], 12);
                L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
                    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
                    maxZoom: 18,
                    id: 'mapbox/satellite-streets-v11',
                    tileSize: 512,
                    zoomOffset: -1,
                    accessToken: 'pk.eyJ1IjoiYWxleHF1aWxpczEiLCJhIjoiY2wxbWI1MThrMGo1MDNjczltdXhwMG00YiJ9.VPlwJJoeRnSrbwBiv8MoHg'
                }).addTo(map);

                var runLayer = omnivore.kml('<?= 'sendas/Senda_' . $id . '.kml' ?>')
                    .on('ready', function() {
                        map.fitBounds(runLayer.getBounds());
                    })
                    .addTo(map);
            </script>
            <div class="container">
                <table class="table-scroll small-first-col">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                        </tr>
                    </thead>
                    <tbody class="body-half-screen">
                        <?php
                        $sql = "SELECT id, nombre FROM senda ORDER BY id ASC ";
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            // output data of each row
                            while ($row = $result->fetch_assoc()) {
                        ?>
                                <tr>
                                    <td><a href="?id=<?= $row["id"] ?> "> <?= $nombre = $row["nombre"] ?> </a></td>
                                </tr>
                        <?php
                            }
                        } else {
                            echo "0 results";
                        }
                        ?>
                    </tbody>
                </table>
                <table class="table-scroll small-first-col">
                    <thead>
                        <tr>
                            <th><?= $nombre ?> </a></th>
                        </tr>
                    </thead>
                    <tbody class="body-half-screen">
                        <tr>
                            <td>Dificultad</td>
                            <td><?= $dificultad ?> </a></td>
                        </tr>
                        <tr>
                            <td>Inicio</td>
                            <td><?= $inicio ?></td>
                        </tr>
                        <tr>
                            <td>Final</td>
                            <td><?= $final ?></td>
                        </tr>
                        <tr>
                            <td>Longitud</td>
                            <td><?= $longitud ?></td>
                        </tr>
                        <tr>
                            <td>Señalización</td>
                            <td><?= $señales ?></td>
                        </tr>
                        <tr>
                            <td>Cota máxima</td>
                            <td><?= $cota_max ?></td>
                        </tr>
                        <tr>
                            <td>Cota mínima</td>
                            <td><?= $cota_min ?></td>
                        </tr>
                    </tbody>
                </table>
            </div>

        </div>
        <div class="pie">
            <footer>
                © Copyright PSI 2022
            </footer>
        </div>
</body>

</html>

<!-- Cerrar conexión con sql -->
<?php
$conn->close();
