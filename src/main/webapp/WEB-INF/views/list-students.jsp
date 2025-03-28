
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
    <style>
        /* Basic Table Styling */
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
            text-align: center;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
        }

        /* Button Styling */
        .button {
            display: inline-block;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            background-color: #4CAF50;  /* Green background */
            color: white;               /* White text */
            font-size: 16px;            /* Larger font size */
            margin: 10px;               /* Add space between buttons */
        }

        .button:hover {
            background-color: #45a049;  /* Darker green when hovered */
        }

        .delete-btn {
            background: red;
        }

        .delete-btn:hover {
            background: darkred;
        }
    </style>
    <script>
        // Confirm before delete
        function confirmDelete(url) {
            if (confirm("Are you sure you want to delete this student?")) {
                window.location.href = url; // Proceed with the delete action
            }
        }
    </script>
</head>
<body>
    <h2 style="text-align: center;">Student List</h2>
    
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th> <!-- Add a column for action buttons -->
            </tr>
        </thead>
        <tbody>
            <!-- Handle Empty Student List -->
            <c:choose>
                <c:when test="${empty students}">
                    <tr>
                        <td colspan="4" style="text-align: center;">No students found!</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <!-- Iterate Over Student List -->
                    <c:forEach var="student" items="${students}">
                        <tr>
                            <td>${student.id}</td>
                            <td>${student.name}</td>
                            <td>${student.email}</td>
                            <td>
                                <!-- Delete Button -->
                                <a href="<c:url value='/students/deleteStudent/${student.id}'/>" class="button delete-btn">Delete</a>

                            </td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>

    <br>
    <div style="text-align: center;">
        <!-- Button to Add New Student -->
        <a href="<c:url value='/students/addStudent'/>" class="button">Add New Student</a>  
        
        <!-- Button to go Back to Home (index.jsp) -->
        <a href="<c:url value='/'/>" class="button">Back to Home</a>
    </div>

</body>
</html>
