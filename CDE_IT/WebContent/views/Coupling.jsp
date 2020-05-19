<%@page import="java.util.ArrayList"%>
<%@page import="model.Couplings"%>
<%@page import="ValueGenerator.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/style/CSS/bootsrtap.min.css">
<script src="<%=request.getContextPath()%>/style/CSS/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<title>Coupling | CDE Solutions</title>
</head>
<body>

	<div class="container">
		<div>
			<br> <img src="<%=request.getContextPath()%>/img/logoe.png"
				style="max-height: 75px; width: 141px; height: 81px" />
			<text style="font-size:30px; color:gray ; margin-left:30px">
			Coupling<text>&nbsp
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
		<div style="overflow: auto;">
			<table class="table table-bordered table-hover"
				style="max-width: 120px;">
				<thead class="thead-dark">
					<tr>
						<th>Line no</th>
						<th>Program statements</th>
						<th>Nr</th>
						<th>Nmcms</th>
						<th>Nmcmd</th>
						<th>Nmcrms</th>
						<th>Nmcrmd</th>
						<th>Nrmcrms</th>
						<th>Nrmcrmd</th>
						<th>Nrmcms</th>
						<th>Nrmcmd</th>
						<th>Nmrgvs</th>
						<th>Nmrgvd</th>
						<th>Nrmrgvs</th>
						<th>Nrmrgvd</th>
						<th>Ccp</th>
					</tr>
				</thead>
				<tbody>
					<%
						coupling test5 = new coupling();
						ArrayList<Couplings> arrayList5 = test5.coupling(session.getAttribute("test_code").toString());

						for (Couplings coupling : arrayList5) {

							int Nr = coupling.getRecursive() * Integer.parseInt(session.getAttribute("recursive").toString());

							int Nmcms = coupling.getRegular_regular()
									* Integer.parseInt(session.getAttribute("regularRegular").toString());

							int Nmcrms = coupling.getRegular_recursive()
									* Integer.parseInt(session.getAttribute("regularRecursive").toString());

							int Nrmcrms = coupling.getRecursive_recursive()
									* Integer.parseInt(session.getAttribute("recursiveRecursive").toString());

							int Nrmcms = coupling.getRecursive_regular()
									* Integer.parseInt(session.getAttribute("recursiveRegular").toString());

							int total = Nr + Nmcms + Nmcrms + Nrmcrms + Nrmcms
									+ (coupling.getRegular_global()
											* Integer.parseInt(session.getAttribute("regularGlobal").toString()))
									+ (coupling.getRegular_regular()
											* Integer.parseInt(session.getAttribute("recursiveGlobal").toString()));
					%>
					<tr>
						<td><%=coupling.getLineNumber()%></td>
						<td><%=coupling.getLine()%></td>
						<td><%=coupling.getRecursive()%></td>
						<td><%=coupling.getRegular_regular()%></td>
						<td>0</td>
						<td><%=coupling.getRegular_recursive()%></td>
						<td>0</td>
						<td><%=coupling.getRecursive_recursive()%></td>
						<td>0</td>
						<td><%=coupling.getRecursive_regular()%></td>
						<td>0</td>
						<td><%=coupling.getRegular_global()%></td>
						<td>0</td>
						<td><%=coupling.getRegular_regular()%></td>
						<td>0</td>
						<td><%=coupling.getRecursive() + coupling.getRegular_regular() + coupling.getRegular_recursive()
						+ coupling.getRecursive_recursive() + coupling.getRecursive_regular()
						+ coupling.getRegular_global() + coupling.getRegular_regular()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
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
					NR - Number of recursive calls <br> NMCMS - Number of calls
					from regular method(s) to other regular methods in the same file <br>
					NMCMD - Number of calls from regular method(s) to other regular
					methods in different files <br> NMCRMS - Number of calls from
					regular method(s) to recursive methods in the same file <br>
					NMCRMD - Number of calls from regular method(s) to recursive
					methods in different files <br> NRMCRMS - Number of calls from
					recursive method(s) to other recursive methods in the same file <br>
					NRMCRMD - Number of calls from recursive method(s) to other
					recursive methods in different files <br> NRMCMS - Number of
					calls from recursive method(s) to regular methods in the same file
					<br> NRMCMD - Number of calls from recursive method(s) to
					regular methods in different files <br> NMRGVS - Number of
					references from regular method(s) to global variables in the same
					file <br> NMRGVD - Number of references from regular method(s)
					to global variables in different files <br> NRMRGVS - Number
					of references from recursive method(s) to global variables in the
					same file <br> NRMRGVD - Number of references from recursive
					method(s) to global variable in different files <br> CCP -
					Complexity of program statement due to coupling <br>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>
	<br>
</body>
</html>