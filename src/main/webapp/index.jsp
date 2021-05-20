<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JSP Tutorial</title>

    <link href="CSS/CSS.css" rel="stylesheet"/>

    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>

<h1>Library Manager 2</h1>




<div class="author">
    <h3>Author</h3>
    <ul>
        <br/>
            <button onclick="location.href='Author/form-Author.jsp';">Create author</button>

            <button onclick="location.href='Author/form-modifyAuthor.jsp';">Modify Author</button>

            <button onclick="location.href='Author/form-deleteAuthor.jsp';">Delete author</button>

        <br/>
    </ul>
</div>


<div class="book">

    <h3>Libro</h3>
    <ul>
        <br/>
        <button onclick="location.href='Book/form-book.jsp';">Create book</button>

        <button onclick="location.href='Book/form-modifyBook.jsp';">modify book</button>

        <button onclick="location.href='Book/form-deleteBookA.jsp';">Delete book</button>

        <br/>
    </ul>

</div>

<div class="edicion">

    <h3>Edition</h3>
    <ul>
        <br/>
        <button onclick="location.href='Library/form-library.jsp';">Create edition</button>

        <button onclick="location.href='Author/form-author.jsp';">modify edition</button>

        <button onclick="location.href='Book/form-deleteBookA.jsp';">Delete edition</button>

        <br/>
    </ul>

</div>

<div class="libreria">

    <h3>Librerias</h3>
    <ul>
        <br/>
        <button onclick="location.href='Library/form-library.jsp';">Create Librerias</button>

        <button onclick="location.href='Library/form-modifyLibrary.jsp';">modify Librerias</button>

        <button onclick="location.href='Library/form-deleteLibrary.jsp';">Delete Librerias</button>

        <br/>
    </ul>

</div>

<h3>Libraries</h3>

<table class="tablas" id="librariesTbl">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

<h3>Authors</h3>

<table id="authorsTbl">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Country</th>
        <th>#books</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

<h3>Books</h3>

<table id="bookTbl">
    <thead>
    <tr>
        <th>Book ID</th>
        <th>Title</th>
        <th>Isbn Number</th>
        <th> author_id</th>
        <th>Genre</th>

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

    // Printing libraries
    printTable(elementId = 'librariesTbl', servlet = 'list-libraries', columns = ['libraryId', 'name']);

    // Printing authors
    printTable(elementId = 'authorsTbl', servlet = 'list-authors', columns = ['authorId','name','country','numBooks']);

    printTable(elementId = 'bookTbl', servlet = 'List-books', columns = ['bnookID','title','isbn_number','author_id','genre']);


</script>

</body>
</html>