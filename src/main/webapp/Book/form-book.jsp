<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>

    <link href="../styleFormatoDatos.css" rel="stylesheet"/>
    <title>Inicio</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="Keywords" content="perros,mascotas,canino,felino">
    <meta name="description" content="Per-ctizens un lugar donde va a poder regstrar a tu amigo de 4 patas  ">
    <meta name="author" content="Andres Nuñez, Juan Felipe Ruiz">
    <script src="https://d3js.org/d3.v5.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<header class="header">
    <div class="container logo-navContanier">
        <nav class="navigation">
            <ul>
                <li><a href="../author.jsp">Autores</a></li>
                <li><a href="../book.jsp">Book</a></li>
                <li><a href="../Library.jsp">Librerias</a></li>
                <li><a href="../Edition.jsp">Librerias</a></li>
                <li><a href="../customer.jsp">Customer</a></li>
            </ul>
        </nav>
    </div>
</header>

<form action="../create-book">
    A id: <input type="text" class="form-control" id="id" name="id">
    <br />
     Author id: <input type="text" class="form-control" id="author_id" name="author_id">
    <br />
    Book title: <input type="text" class="form-control" id="title" name="title">
    <br />
    Book ISBN: <input type="text" class="form-control" id="isbn" name="isbn">
    <br />
    Genre <input type="text" class="form-control" id="genre" name="genre">
    <br />
    Descripcion <input type="text" class="form-control" id="descripcion" name="descripcion">
    <br />
    year <input type="text" class="form-control" id="year" name="year">
    <br />
    <input type="submit" value="Create book!">
</form>

</body>
</html>
