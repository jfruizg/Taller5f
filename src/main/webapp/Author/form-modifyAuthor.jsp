
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
<body>

<form action="../modify-Author">
    Id: <input type="text" id="id" class="form-control" name="id_author">
    <br />
    Name: <input type="text" id="name" class="form-control" name="name">
    <br />
    Country: <input type="text" id="country" class="form-control" name="country">
    <br />
    <input type="submit" value="Modify">
</form>

</body>
</html>
