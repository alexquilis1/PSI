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
        $nombre1 = $row["nombre"];
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
    <!-- Fuente para th -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Secular+One&display=swap" rel="stylesheet">

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
                    <li><a href="estadisticas.php">Estadísticas</a></li>
                    <li><a href="enlaces.html">Enlaces de interés</a></li>
                </ul>
                </nav>
            </div>
        </header>
    </div>
    <div class="cuerpo">
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
                    $sql = "SELECT id, nombre FROM senda ORDER BY nombre ASC ";
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
                        <th><?= $nombre1 ?> </a></th>
                    </tr>
                </thead>
                <tbody class="body-half-screen">
                    <tr>
                        <td><b>Categoría(s)</b></td>
                        <td>
                            <?php
                            $sql = "select nombre_c from senda as s, categoria as c, pertenecen as p where c.id_c1 = p.id_c and s.id = p.id_s and s.id = " . $id;
                            $result = $conn->query($sql);
                            while ($row = $result->fetch_assoc()) {
                                echo " | " . $row['nombre_c'] . " | " . "<br>";
                            }
                            ?>
                        </td>
                    </tr>
                    <tr>
                        <td><b>Dificultad</b></td>
                        <td><?= $dificultad ?> </a></td>
                    </tr>
                    <tr>
                        <td><b>Inicio</b></td>
                        <td><?= $inicio ?></td>
                    </tr>
                    <tr>
                        <td><b>Final</b></td>
                        <td><?= $final ?></td>
                    </tr>
                    <tr>
                        <td><b>Longitud</b></td>
                        <td><?= $longitud ?></td>
                    </tr>
                    <tr>
                        <td><b>Señalización</b></td>
                        <td><?= $señales ?></td>
                    </tr>
                    <tr>
                        <td><b>Cota máxima</b></td>
                        <td><?= $cota_max ?></td>
                    </tr>
                    <tr>
                        <td><b>Cota mínima</b></td>
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
