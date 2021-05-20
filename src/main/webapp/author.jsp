<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="stylecssPaginaMenu.css" rel="stylesheet"/>
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
                <li><a href="author.jsp">Autores</a></li>
                <li><a href="book.jsp">Book</a></li>
                <li><a href="Library.jsp">Librerias</a></li>

            </ul>
        </nav>
    </div>
</header>
<main class="main">
    <div>
        <h3>Author</h3>
        <ul>
            <br/>
            <button type="button" class="btn btn-primary" onclick="location.href='Author/form-Author.jsp';">Creat Author</button>


            <button type="button" class="btn btn-primary" onclick="location.href='Author/form-modifyAuthor.jsp';">Modify Author</button>

            <button type="button" class="btn btn-primary" onclick="location.href='Author/form-deleteAuthor.jsp';">Delete author</button>

            <br/>
        </ul>
    </div>
</main>

<table id="authorsTbl">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Name</th>
        <th scope="col">Country</th>
        <th scope="col">numBooks</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

<script>
    function printTable(elementId, servlet, columns, actions = []) {

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                var data = JSON.parse(xhr.responseText);

                var tbodyRef = document.getElementById(elementId).getElementsByTagName('tbody')[0];

                data.map(d => {

                    var newRow = tbodyRef.insertRow();

                    columns.map(c => {
                        var cell = newRow.insertCell();
                        var text = document.createTextNode(d[c]);
                        cell.appendChild(text);
                    });

                    if (actions.includes('create-book')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        action.setAttribute('onclick', 'location.href="./form-book.jsp?authorId=' + d['authorId'] + '";');
                        var text = document.createTextNode('Create book');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }

                    if (actions.includes('delete-author')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        // action.setAttribute('onclick', 'location.href="./delete-author?authorId=' + d['authorId'] + '";');
                        var text = document.createTextNode('Delete author');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }

                    if (actions.includes('create-book')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                        //  action.setAttribute('onclick', 'location.href="./delete-author?authorId=' + d['authorId'] + '";');
                        var text = document.createTextNode('creat edicion');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }


                });

            }
        }
        xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
        xhr.send(null);

    }

    // Printing authors
    printTable(elementId = 'authorsTbl', servlet = 'list-authors', columns = ['authorId','name','country','numBooks']);

</script>

</body>
</html>
