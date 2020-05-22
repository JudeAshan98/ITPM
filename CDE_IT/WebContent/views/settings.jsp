<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>CDE IT || Settings</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	
<link rel="stylesheet" href="<%=request.getContextPath()%>/style/bootsrtap.min.css">
<script src="<%=request.getContextPath()%>/style/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"> </script>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<br>

	<div class="container">
		<div>
			<img src="<%=request.getContextPath()%>/img/logoe.png" style="max-height: 75px">
			<text style="font-size:30px; color:gray ; margin-left:30px;">
			Settings<text>
			<hr />
		</div>
		<br>

		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li class="nav-item"><a class="nav-link active" data-toggle="tab"
				href="#vms">VMS</a></li>
			<li class="nav-item"><a class="nav-link"
				data-toggle="tab" href="#inheritance">Inheritance</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#Coupling">Coupling</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#Control">Control Structures</a></li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div id="vms" class="container tab-pane active">
				<br>
				<div class="row">
					<div class="col-sm border border-success">
						<br>
						<h5 align="center">Weights related to the size factor</h5>
						<form  method="post" action="sizeUpdater">
						<div class="table-responsive">
							<br>
							<table class="table table-bordered">
								<thead class="thead-light">
									<tr>
										<th>Program Component</th>
										<th>Weight</th>
									</tr>
								</thead>
								<c:forEach items="${SizeList}" var="Listsz" varStatus="theCountSz">
								<tbody>
									<tr>
										<td>Keyword</td>
										<td><input type="number" name="keywordS" class="form-control" value="${Listsz[0]}" style="width:60px"></td>
									</tr>
									<tr>
										<td>Identifier</td>
										<td><input type="number" name="IdentifierS" class="form-control"  value="${Listsz[1]}"  style="width:60px"></td>
									</tr>
									<tr>
										<td>Operator</td>
										<td><input type="number" name="OperatorS" class="form-control" value="${Listsz[2]}"  style="width:60px"></td>
									</tr>
									<tr>
										<td>Numerical value</td>
										<td><input type="number" name="NumericalS" class="form-control" value="${Listsz[3]}"  style="width:60px"></td>
									</tr>
									<tr>
										<td>String literal</td>
										<td><input type="number" name="literalS" class="form-control" value="${Listsz[4]}"  style="width:60px"></td>
									</tr>
								</tbody>
								</c:forEach>
							</table>
						</div>
						<button type="submit" value ="Save" class="btn btn-success">Save</button></form>
					</div>
					&nbsp
					<div class="col-sm border border-success">
						<br>
						<h5 align="center">Weights related to the method factor</h5>
						<form  method="post" action="methodUpdater">
						<div class="table-responsive">
							<br>
							<table class="table table-bordered">
								<thead class="thead-light">
									<tr>
										<th>Program Component</th>
										<th>Weight</th>
									</tr>
								</thead>
								<c:forEach items="${MethList}" var="Listv" varStatus="theCountv">
								<tbody>
									<tr>
										<td>Method with a primitive return type</td>
										<td><input type="number" name="PrimitiveReturnM" class="form-control"  value="${Listv[0]}"   style="width:60px"></td>
									</tr>
									<tr>
										<td>Method with a composite return type</td>
										<td><input type="number" name="CompositeReturnM" class="form-control"  value="${Listv[1]}"   style="width:60px"></td>
									</tr>
									<tr>
										<td>Method with a void return type</td>
										<td><input type="number" name="VoidReturnM" class="form-control"  value="${Listv[2]}"   style="width:60px"></td>
									</tr>
									<tr>
										<td>Primitive data type parameter</td>
										<td><input type="number" name="PrimitiveParaM" class="form-control"  value="${Listv[3]}"   style="width:60px"></td>
									</tr>
									<tr>
										<td>Composite data type parameter</td>
										<td><input type="number" name="CompositeParaM" class="form-control"  value="${Listv[4]}"   style="width:60px"></td>
									</tr>
								</tbody>
								</c:forEach>
							</table>
							
						</div>
						<button type="submit" value ="Save" class="btn btn-success">Save</button></form>
						<p></p>
					</div>
				</div>
				<br>
				<div class="row justify-content-md-center">
					<div class="col-md-6 border border-success">
						<br>
						<h5 align="center">Weights related to the variable factor</h5>
						<form  method="post" action="VarUpdater">
						<div class="table-responsive">
							<br>
							<table class="table table-bordered">
								<thead class="thead-light">
									<tr>
										<th>Program Component</th>
										<th>Weight</th>
									</tr>
								</thead>
								<c:forEach items="${VarList}" var="var" varStatus="theCountVar">
								<tbody>
									<tr>
										<td>Global variable</td>
										<td><input type="number" name="GlobalV" class="form-control" value="${var[0]}"  style="width:60px"></td>
									</tr>
									<tr>
										<td>Local variable</td>
										<td><input type="number" name="LocalV" class="form-control" value="${var[1]}"  style="width:60px"></td>
									</tr>
									<tr>
										<td>Primitive data type variable</td>
										<td><input type="number" name="PrimitiveDataV" class="form-control" value="${var[2]}"  style="width:60px"></td>
									</tr>
									<tr>
										<td>Composite data type variable</td>
										<td><input type="number" name="CompositeDataV" class="form-control"  value="${var[3]}" style="width:60px"></td>
									</tr>
								</tbody>
								</c:forEach>
							</table>
						</div>
						<button type="submit" value ="Save" class="btn btn-success">Save</button></form>
						<p></p>
					</div>
				</div>
				<br>
			</div>
			<div id="inheritance" class="container tab-pane fade">
				<br>
				<div class="col-sm border border-success">
					<br>
					<h5 align="center">Weights related to the inheritance factor</h5>
					<form  method="post" action="InhUpdater">
					<div class="table-responsive">
						<br>
						<table class="table table-bordered">
							<thead class="thead-light">
								<tr>
									<th>Inherited Pattern</th>
									<th>Weight</th>
								</tr>
							</thead>
							<c:forEach items="${InhList}" var="ListInh" varStatus="theCount">
							<tbody>
								<tr>
									<td>A class with no inheritance (direct or indirect)</td>
									<td><input type="number" name="zeroU" class="form-control" value="${ListInh[0]}"  style="width:60px"></td>
								</tr>
								<tr>
									<td>A class inheriting (directly or indirectly) from one user-defined class</td>
									<td><input type="number" name="oneU" class="form-control" value="${ListInh[1]}"  style="width:60px"></td>
								</tr>
								<tr>
									<td>A class inheriting (directly or indirectly) from two user-defined classes</td>
									<td><input type="number" name="twoU" class="form-control" value="${ListInh[2]}"  style="width:60px"></td>
								</tr>
								<tr>
									<td>A class inheriting (directly or indirectly) from three user-defined classes</td>
									<td><input type="number" name="threeU" class="form-control" value="${ListInh[3]}"  style="width:60px"></td>
								</tr>
								<tr>
									<td>A class inheriting (directly or indirectly) from more than three user-defined classes</td>
									<td><input type="number" name="fourU" class="form-control" value="${ListInh[4]}"  style="width:60px"></td>
								</tr>
							</tbody>
							</c:forEach>
						</table>
					</div>
					<button type="submit" value ="Save" class="btn btn-success">Save</button></form>
					<p></p>
				</div>
			</div>
			<div id="Coupling" class="container tab-pane fade">
				<br>
				<div class="col-sm border border-success">
					<br>
					<h5 align="center">Weights related to the coupling factor</h5>
					<form  method="post" action="CouplingUpdater">
					<div class="table-responsive">
						<br>
						<table class="table table-bordered">
							<thead class="thead-light">
								<tr>
									<th>Coupling Type</th>
									<th>Weight</th>
								</tr>
							</thead>
							<c:forEach items="${CupList}" var="postcup" varStatus="theCountcup">
							<tbody>
								<tr>
									<td>A recursive call</td>
									<td><input type="number" name="recursiveCall" class="form-control"  value="${postcup[0]}" style="width:60px"></td>
								</tr>
								<tr>
									<td>A regular method calling another regular method in the same file</td>
									<td><input type="number" name="RGregularSame" class="form-control" value="${postcup[1]}"  style="width:60px"></td>
								</tr>
								<tr>
									<td>A regular method calling another regular method in a different file</td>
									<td><input type="number" name="RGregularDiff" class="form-control" value="${postcup[2]}"   style="width:60px"></td>
								</tr>
								<tr>
									<td>A regular method calling a recursive method in the same file</td>
									<td><input type="number" name="RGrecursiveSame" class="form-control"  value="${postcup[3]}"  style="width:60px"></td>
								</tr>
								<tr>
									<td>A regular method calling a recursive method in a different file</td>
									<td><input type="number" name="RGrecursiveDiff" class="form-control"  value="${postcup[4]}" style="width:60px"></td>
								</tr>
								<tr>
									<td>A recursive method calling another recursive method in the same file</td>
									<td><input type="number" name="RSrecursiveSame" class="form-control"  value="${postcup[5]}" style="width:60px"></td>
								</tr>
								<tr>
									<td>A recursive method calling another recursive method in a different file</td>
									<td><input type="number" name="RSrecursiveDiff" class="form-control" value="${postcup[6]}"  style="width:60px"></td>
								</tr>
								<tr>
									<td>A recursive method calling a regular method in the same file</td>
									<td><input type="number" name="RSregularSame" class="form-control" value="${postcup[7]}"  style="width:60px"></td>
								</tr>
								<tr>
									<td>A recursive method calling a regular method in a different file</td>
									<td><input type="number" name="RSregularDiff" class="form-control" value="${postcup[8]}"  style="width:60px"></td>
								</tr>
								<tr>
									<td>A regular method referencing a global variable in the same file</td>
									<td><input type="number" name="RMGSame" class="form-control"  value="${postcup[9]}" style="width:60px"></td>
								</tr>
								<tr>
									<td>A regular method referencing a global variable in a different file</td>
									<td><input type="number" name="RMGDiff" class="form-control"  value="${postcup[10]}" style="width:60px"></td>
								</tr>
								<tr>
									<td>A recursive method referencing a global variable in the same file</td>
									<td><input type="number" name="RSMGSame" class="form-control"  value="${postcup[11]}" style="width:60px"></td>
								</tr>
								<tr>
									<td>A recursive method referencing a global variable in a different file</td>
									<td><input type="number" name="RSMGDiff" class="form-control"  value="${postcup[12]}" style="width:60px"></td>
								</tr>
							</tbody>
							</c:forEach>
						</table>
					</div>
					<button type="submit" value ="Save" class="btn btn-success">Save</button></form>
					<p></p>
				</div>
			</div>
			<div id="Control" class="container tab-pane fade">
				<br>
				<div class="col-sm border border-success">
					<br>
					<h5 align="center">Weights related to the control structure factor</h5>
					<form  method="post" action="ControlUpdater">
					<div class="table-responsive">
						<br>
						<table class="table table-bordered">
							<thead class="thead-light">
								<tr>
									<th>Program Component</th>
									<th>Weight</th>
								</tr>
							</thead>
							<c:forEach items="${CsList}" var="post" varStatus="theCount1">
							<tbody> 
								<tr>
									<td>A conditional control structure such as an 'if' or 'else-if' condition</td>
									<td><input type="number" name="ifelse" class="form-control" value="${post[0]}"  style="width:60px"></td>
								</tr>
								<tr>
									<td>An iterative control structure such as a 'for', 'while', or 'do-while' loop</td>
									<td><input type="number" name="fwd" class="form-control" value="${post[1]}"  style="width:60px"></td>
								</tr>
								<tr>
									<td>The 'switch' statement in a 'switch-case' control structure</td>
									<td><input type="number" name="switch" class="form-control" value="${post[2]}"  style="width:60px"></td>
								</tr>
								<tr>
									<td>Each 'case' statement in a 'switch-case' control structure </td>
									<td><input type="number"  name="case" class="form-control"  value="${post[3]}" style="width:60px"></td>
								</tr>
							</tbody>
							</c:forEach>
						</table>
					</div>
					<button type="submit" value ="Save" class="btn btn-success">Save</button></form>
					<p></p>
				</div>
			</div>
		</div>

	</div>
</body>
</html>
