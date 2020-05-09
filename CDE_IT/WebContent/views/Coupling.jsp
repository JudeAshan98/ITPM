<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" href="<%=request.getContextPath()%>/style/CSS/bootsrtap.min.css">
<script src="<%=request.getContextPath()%>/style/CSS/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<title>Coupling | CDE Solutions</title>
</head>
<body style="background-color: #fff; margin-top: 30px; margin-left: 50px">
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<div class="container">
		<div>
			<img src="<%=request.getContextPath()%>/img/logoe.png"
				style="max-height: 75px; width: 141px; height: 81px" />
			<text style="font-size:30px; color:gray ; margin-left:30px">
			Coupling<text>&nbsp
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
	</div>
	<div class="container" style="width:1500px">	
		<div style="overflow: auto;">
			<table class="table table-bordered table-hover"	style="max-width: 120px;">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Line No.</th>
						<th scope="col">Program Statement</th>
						<th scope="col">NR</th>
						<th scope="col">NMCMS</th>
						<th scope="col">NMCMD</th>
						<th scope="col">NMCRMS</th>
						<th scope="col">NMCRMD</th>
						<th scope="col">NRMCRMS</th>
						<th scope="col">NRMCRMD</th>
						<th scope="col">NRMCMS</th>
						<th scope="col">NRMCMD</th>
						<th scope="col">NMRGVS</th>
						<th scope="col">NMRGVD</th>
						<th scope="col">NRMRGVS</th>
						<th scope="col">NRMRGVD</th>
						<th scope="col">CCP</th>
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
						<td>${post[5]}</td>
						<td>${post[6]}</td>
						<td>${post[7]}</td>
						<td>${post[8]}</td>
						<td>${post[9]}</td>
						<td>${post[10]}</td>
						<td>${post[11]}</td>
						<td>${post[12]}</td>
						<td>${post[13]}</td>
						<td>${post[14]}</td>
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
						NR - Number of recursive calls <br>
						NMCMS - Number of calls from regular method(s) to other regular methods in the same file <br>
						NMCMD - Number of calls from regular method(s) to other regular methods in different files <br>
						NMCRMS - Number of calls from regular method(s) to recursive methods in the same file <br>
						NMCRMD - Number of calls from regular method(s) to recursive methods in different files <br>
						NRMCRMS - Number of calls from recursive method(s) to other recursive methods in the same file <br>
						NRMCRMD - Number of calls from recursive method(s) to other recursive methods in different files <br>
						NRMCMS - Number of calls from recursive method(s)  to regular methods in the same file <br>
						NRMCMD - Number of calls from recursive method(s) to regular methods in different files <br>
						NMRGVS - Number of references from regular method(s) to global variables in the same file <br>
						NMRGVD - Number of references from regular method(s) to global variables in different files <br>
						NRMRGVS - Number of references from recursive method(s) to global variables in the same file <br>
						NRMRGVD - Number of references from recursive method(s) to global variable in different files <br>
						CCP - Complexity of program statement due to coupling <br>
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