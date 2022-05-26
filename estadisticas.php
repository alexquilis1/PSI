<?php

use LDAP\Result;

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
?>
<!DOCTYPE html>
<html>

<head lang="en">
    <meta charset="UTF-8">
    <title>
        Traccia
    </title>
    <link rel="stylesheet" href="estilo-html.css">

    <!-- Fuente para h1 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Paytone+One&display=swap" rel="stylesheet">

    <!-- Favicon -->
    <link rel="icon" href="logo/tortuga_fav.png" type="image/png">
</head>

<body>
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
        <h2>Dificultad de las sendas</h2>
        <p>
            El porcentaje de las sendas con dificultad baja es:
            <?php
            $sql = "select ((select count(*) from senda where dificultad='Baja')/(select count(*) from senda)*100) as result";
            $result = $conn->query($sql);
            while ($row = $result->fetch_assoc()) {
                echo $row['result'] . '%';
            }
            ?>
        </p>
        <p>
            El porcentaje de las sendas con dificultad baja-media es:
            <?php
            $sql = "select ((select count(*) from senda where dificultad='Baja-Media')/(select count(*) from senda)*100) as result";
            $result = $conn->query($sql);
            while ($row = $result->fetch_assoc()){
                echo $row['result'].'%';
            }
            ?>
        </p>
        <p>
            El porcentaje de las sendas con dificultad media es:
            <?php
            $sql = "select ((select count(*) from senda where dificultad='Media')/(select count(*) from senda)*100) as result";
            $result = $conn->query($sql);
            while($row = $result->fetch_assoc()){
                echo $row['result'].'%';
            }
            ?>
        </p>
        <p>
            El porcentaje de las sendas con dificultad media-alta es:
            <?php
            $sql = "select ((select count(*) from senda where dificultad='Media-Alta')/(select count(*) from senda)*100) as result";
            $result = $conn->query($sql);
            while($row = $result->fetch_assoc()){
                echo $row['result'].'%';
            }
            ?>
        </p>
        <p>
            El porcentaje de las sendas con dificultad alta es:
            <?php
            $sql = "select ((select count(*) from senda where dificultad='Alta')/(select count(*) from senda)*100) as result";
            $result = $conn->query($sql);
            while($row = $result->fetch_assoc()){
                echo $row['result'].'%';
            }
            ?>
        </p>
        <h2>Longitud de las sendas</h2>
        <h3>Sendas circulares</h3>
        <h2>Categoría de las sendas</h2>
        <h2>Señalización de las sendas</h2>
        
    </div>
    <div class="pie">
        <footer>
            © Copyright PSI 2022
        </footer>
    </div>
</body>



</html>