<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>
    <style>
        body {
            background-color: #f0f0f0;
            font-family: Arial;
            text-align: center;
            padding-top: 150px;
        }
        input[type=text], input[type=password] {
            padding: 10px;
            margin: 10px;
            width: 250px;
        }
        input[type=submit] {
            padding: 10px 25px;
            background-color: blue;
            color: white;
            border: none;
            margin-top: 20px;
        }
        h2 {
            color: navy;
        }
    </style>
</head>
<body>
    <h2>🔐 Admin Login</h2>
    <form method="post" action="AdminCheck">
        <input type="text" name="user" placeholder="Username" required><br>
        <input type="password" name="pass" placeholder="Password" required><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>