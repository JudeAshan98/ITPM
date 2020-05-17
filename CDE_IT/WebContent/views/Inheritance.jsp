<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/style/bootsrtap.min.css">
<script src="<%=request.getContextPath()%>/style/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Inheritance| CDE Solutions</title>
</head>
<body style="background-color: #fff;">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<br>
	<div class="container">
		<div>
			<img src="<%=request.getContextPath()%>/img/logoe.png"
				style="max-height: 75px" />
			<text style="font-size:30px; color:gray ; margin-left:30px">Inheritance<text>
			<button type="button" onclick="window.print()"
				class="btn btn-info btn-lg"
				style="background-color: transparent; float: right; margin-top: 30px; margin-left: 30px">
				<img src="<%=request.getContextPath()%>/img/print.png"
					style="max-height: 40px; max-width =: 40px;">
			</button>
			<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
				data-target="#myModal" style="float: right; margin-top: 30px;">View
				Keywords</button>
			<hr />
		</div>

		<!-- setting values to variables from servlet -->

		<%
			String userlabel = (String) request.getAttribute("check");
		int totalcom = (Integer) request.getAttribute("total_complex");
		int totalInhritance = (Integer) request.getAttribute("total_inheritance");
		int totaldirect = (Integer) request.getAttribute("total_direct");
		int totalindirect = (Integer) request.getAttribute("total_indirect");
		%>

		<!-- checking condition to display error if not up to code standards -->
		<c:if test="${check!=null}">
			<p style="color: red">
				<b> <%=userlabel%>
				</b>
			</p>
			<p style="color: red">
				<b> -1 in value shows incorrect use of brackets "{" </b>
			</p>
			<p style="color: red">** There should be a space between class
				name and "{" bracket</p>
			<p>
				<b>eg: " class Year extends day { "</b>
			</p>
			<a
				href="https://courses.cs.washington.edu/courses/cse143/16au/style/curly-brackets-and-indentation.html"><b>
					${link}</b> </a>
		</c:if>

		<div class="row">
			<table class="table table-bordered table-hover">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Count</th>
						<th scope="col">Class Name</th>
						<th scope="col">Ndi</th>
						<th scope="col">Nidi</th>
						<th scope="col">Ti</th>
						<th scope="col">Ci</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${Code_string}" var="post" varStatus="theCount1">
						<tr>
							<th scope="row">${theCount1.count}</th>

							<!-- if else to check if there is error if so its highlighted in red -->
							<c:choose>
								<c:when test="${post[1]<0||post[2]<0}">
									<td style="background-color: red">${post[0]}</td>
									<td style="background-color: red">${post[1]}</td>
									<td style="background-color: red">${post[2]}</td>
									<td style="background-color: red">${post[3]}</td>
									<td style="background-color: red">${post[4]}</td>
								</c:when>
								<c:otherwise>
									<td>${post[0]}</td>
									<td>${post[1]}</td>
									<td>${post[2]}</td>
									<td>${post[3]}</td>
									<td>${post[4]}</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>

					<!-- if else to check if there is error in total if so its highlighted in red -->
					<c:choose>
						<c:when test="${total_direct<0||total_indirect<0 }">
							<tr>
								<td style="background-color: red"></td>
								<td style="background-color: red"><b>Total</b></td>
								<td style="background-color: red"><b><%=totaldirect%></b></td>
								<td style="background-color: red"><b><%=totalindirect%></b></td>
								<td style="background-color: red"><b><%=totalInhritance%></b></td>
								<td style="background-color: red"><b><%=totalcom%></b></td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td></td>
								<td><b>Total</b></td>
								<td><b><%=totaldirect%></b></td>
								<td><b><%=totalindirect%></b></td>
								<td><b><%=totalInhritance%></b></td>
								<td><b><%=totalcom%></b></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<!-- The Modal -->
		<div class="modal" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Ref Keywords</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						NDI - No of Direct Inheritances <br> NIDI - No of Indirect
						Inheritances <br> TI - Total Inheritances <br> CI -
						Inheritance Complexity of a program statement of a class <br>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>