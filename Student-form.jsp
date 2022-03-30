<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Student Form</title>
</head>
<body>
	<div class="container">
		<h3>Add Student</h3>
		<hr>
		<p class="h4 mb-4">Student</p>
		<form action="/Student_Management/student/save" method="POST">
		<input type = "hidden" name = "id" value = "${Student.id}"/>
		<div class="form-inline">
		<input type="text" name="firstName" value="${Student.firstName}" class="form-control mb-4 col-4" placeholder="FirstName">
		</div>
		<div class="form-inline">
		<input type="text" name="lastName" value="${Student.lastName}" class="form-control mb-4 col-4" placeholder="LastName">
		</div>
		<div class="form-inline">
		<input type="text" name="course" value="${Student.course}" class="form-control mb-4 col-4" placeholder="Course">
		</div>
		<div class="form-inline">
		<input type="text" name="country" value="${Student.country}" class="form-control mb-4 col-4" placeholder="Country">
		</div>
		<button type="submit" class="btn btn-info col-2">Save</button>
		<form>
		<hr>
		<a href="/Student_Management/student/list">Back to Students List</a>
		</form>
		</form>
		</div>
	</body>
</html>		