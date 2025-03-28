<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Management System</title>
    <style>
        /* General Styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #333; /* Dark background */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: flex-start; /* Moves content towards the top */
            height: 100vh;
        }

        /* White Box Container */
        .container {
            width: 50%;
            background: white;
            padding: 20px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            border-radius: 8px;
            text-align: center;
            margin-top: 100px; /* Moves box down */
        }

        /* Header */
        header {
            background: #007bff;
            color: white;
            padding: 15px;
            font-size: 22px;
            border-radius: 8px 8px 0 0;
        }

        /* Buttons */
        .button {
            display: inline-block;
            background: #28a745;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            transition: 0.3s;
            margin-top: 10px;
        }

        .button:hover {
            background: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to the Student Management System</h1>

        <p>
            <a href="<c:url value='/students'/>" class="button">View All Students</a>
           <a href="<c:url value='/students/addStudent'/>" class="button">Add a New Student</a>
        </p>
    </div>
</body>
</html>
