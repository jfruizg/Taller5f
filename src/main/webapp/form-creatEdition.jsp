<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JPA Tutorial</title>
</head>
<body>

<form action="./create-edition">

    bookID : <input type="hidden" id="bookId" name="bookId">
    <br />
  Descripcion: <input type="text" id="Descripcion" name="Descripcion">
    <br />
  Year: <input type="text" id="Year" name="Year">
    <br />
    Edition id: <input type="text" id="edition_id" name="edition_id">

    <input type="submit" value="Create Edition">
</form>

</body>
</html>
