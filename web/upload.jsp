<%--
  Created by IntelliJ IDEA.
  User: cb-sarath
  Date: 2019-09-12
  Time: 07:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        label {
            /*display: block;*/
            font: 1rem 'Fira Sans', sans-serif;
        }
        input,
        label {
            margin: .4rem 0;
        }
        form {
            margin: 200px auto;
            width: 400px;
            padding: 1em;
            border: 1px solid #ccc;
            border-radius: 1em;
        }
        form div + div {
            margin-top: 1em;
        }
        button {
            margin-left: .5em;
        }
    </style>
</head>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
    <div>
        <label for="file">Choose a CSV file:</label>
        <input type=file id="file" name="file" accept=".csv">
    </div>
    <div>
        <button type="submit">Upload</button>
    </div>
</form>
</body>
</html>

