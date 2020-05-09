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
<title>Summary | CDE Solutions</title>
</head>
<body style="background-color: #fff;">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<br>
	<div class="container">
		<div>
			<img src="<%=request.getContextPath()%>/img/logoe.png"
				style="max-height: 75px" />
			<text style="font-size:30px; color:gray ; margin-left:30px">Summary<text>
			<button type="button" onclick="window.print()" class="btn btn-info btn-lg"
				style="background-color: transparent; float: right; margin-top: 30px; margin-left: 30px">
				<img src="<%=request.getContextPath()%>/img/print.png"
					style="max-height: 40px; max-width =: 40px;">
			</button>
			<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
				data-target="#myModal" style="float: right; margin-top: 30px;">View
				Keywords</button>
			<hr />
		</div>
		<div class="row">
			<table class="table table-bordered table-hover">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Line No.</th>
						<th scope="col">Program Statement</th>
						<th scope="col">CS</th>
						<th scope="col">CV</th>
						<th scope="col">CM</th>
						<th scope="col">CI</th>
						<th scope="col">CCP</th>
						<th scope="col">CCS</th>
						<th scope="col">TCPS</th>
					</tr>
				</thead>
				<c:forEach items="${Code_string}" var="post" varStatus="theCount1">
					<tbody>
						<tr>
							<th scope="row">${theCount1.count}</th>
							<td>${post[0]}</td>
							<td>${post[1]}</td>
							<td>${post[2]}</td>
							<td>${post[3]}</td>
							<td>${post[4]}</td>
							<td>${post[5]}</td>
							<td>${post[6]}</td>
							<td>${post[7]}</td>
						</tr>
					</tbody>
				</c:forEach>
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
						CS - No of direct inheritances <br>
						CV - No of indirect inheritances <br>
						CM - Total inheritances <br>
						CI - Inheritance complexity of a program statement of a class <br>
						CCP - No of indirect inheritances <br>
						CCS - Total inheritances <br>
						TCPS - Inheritance complexity of a program statement of a class <br>
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