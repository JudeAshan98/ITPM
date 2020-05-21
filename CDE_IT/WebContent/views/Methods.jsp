<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/style/CSS/bootsrtap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/style/CSS/style.css">
<script src="<%=request.getContextPath()%>/style/CSS/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<title>Methods | CDE Solutions</title>
</head>
<body style="background-color: #fff;">

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



	<br>
	<div class="container">
		<div>
			<img src="<%=request.getContextPath()%>/img/logoe.png"
				style="max-height: 75px; width: 141px; height: 81px" />
			<text style="font-size:30px; color:gray ; margin-left:30px">
			Methods<text>&nbsp
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

		<%
			int tot_Wmrt = (Integer) request.getAttribute("Total_Wmrt");
			int tot_Npdtp = (Integer) request.getAttribute("Total_Npdtp");
			int tot_Ncdtp = (Integer) request.getAttribute("Total_Ncdtp");
			int tot_Cm = (Integer) request.getAttribute("Total_Cm");
		%>

		<div class="row">
			<table class="table table-bordered table-hover">

				<thead class="thead-dark">
					<tr>
						<th scope="col">Line No.</th>
						<th scope="col">Program Statement</th>
						<th scope="col">WMRT</th>
						<th scope="col">NPDTP</th>
						<th scope="col">NCDTP</th>
						<th scope="col">CM</th>
					</tr>
				</thead>
				<c:forEach items="${Code_string}" var="post" varStatus="theCount1">
					<tbody>
						<tr>
							<td>${theCount1.count}</td>
							<td>${post[0]}</td>
							<td>${post[1]}</td>
							<td>${post[2]}</td>
							<td>${post[3]}</td>
							<td>${post[4]}</td>
						</tr>
				</c:forEach>
				<tr>
					<td><b>#</b></td>
					<td><b>Total</b></td>
					<td><b><%=tot_Wmrt%></b></td>
					<td><b><%=tot_Npdtp%></b></td>
					<td><b><%=tot_Ncdtp%></b></td>
					<td><b><%=tot_Cm%></b></td>
				</tr>
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
						WMRT - Weight due to method return type <br> NPDTP - Number
						of primitive data type parameters <br> NCDTP - Number of
						composite data type parameters <br> CM - Complexity of a line
						which includes a method signature <br>
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