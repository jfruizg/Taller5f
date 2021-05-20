<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
</head>
<body>

<form action="../create-book">
    A id: <input type="text" id="id" name="id">
    <br />
     Author id: <input type="text" id="author_id" name="author_id">
    <br />
    Book title: <input type="text" id="title" name="title">
    <br />
    Book ISBN: <input type="text" id="isbn" name="isbn">
    <br />
    Genre <input type="text" id="genre" name="genre">
    <br />
    Descripcion <input type="text" id="descripcion" name="descripcion">
    <br />
    year <input type="text" id="year" name="year">
    <br />
    <input type="submit" value="Create book!">
</form>

</body>
</html>
