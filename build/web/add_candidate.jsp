<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register Candidate</title>
    <style>
        body {
            background-color: #f0f8ff;
            text-align: center;
            padding-top: 50px;
        }
        input, select {
            margin: 10px;
            padding: 10px;
            border-radius: 8px;
        }
    </style>
</head>
<body>
    <h2>Register Candidate</h2>
    <form method="post" action="AddCandidate">
        First Name: <input type="text" name="fname" required><br>
        Last Name: <input type="text" name="lname" required><br>
        Mobile No: <input type="text" name="mobile" required><br>
        Email: <input type="email" name="email" required><br>
        Party Name: <input type="text" name="party" required><br>
        <input type="submit" value="Register Candidate">
    </form>
</body>
</html>