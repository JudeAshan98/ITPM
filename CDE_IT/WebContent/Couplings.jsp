<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CDE CODE EXTRACTOR</title>
<link rel="stylesheet" href="style/bootsrtap.min.css">
<script src="style/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js">
	
</script>
<style>
.hoverable {
	display: inline-block;
	backface-visibility: hidden;
	vertical-align: middle;
	position: relative;
	box-shadow: 0 0 1px rgba(0, 0, 0, 0);
	tranform: translateZ(0);
	transition-duration: .3s;
	transition-property: transform;
}

.hoverable:before {
	position: absolute;
	pointer-events: none;
	z-index: -1;
	content: '';
	top: 100%;
	left: 5%;
	height: 10px;
	width: 90%;
	opacity: 0;
	background: blue;
	background: radial-gradient(ellipse at center, rgba(255, 255, 255, 0.35)
		0%, rgba(255, 255, 255, 0) 80%);
	/* W3C */
	transition-duration: 0.3s;
	transition-property: transform, opacity;
}

.hoverable:hover, .hoverable:active, .hoverable:focus {
	transform: translateY(-5px);
}

.hoverable:hover:before, .hoverable:active:before, .hoverable:focus:before
	{
	opacity: 1;
	transform: translateY(-5px);
}

@
keyframes bounce-animation { 16.65% {
	-webkit-transform: translateY(8px);
	transform: translateY(8px);
}

33
.3

 

%
{
-webkit-transform


:

 

translateY


(-6
px
);


	

transform


:

 

translateY


(-6
px
);




}
49
.95

 

%
{
-webkit-transform


:

 

translateY


(4
px
);


	

transform


:

 

translateY


(4
px
);




}
66
.6

 

%
{
-webkit-transform


:

 

translateY


(-2
px
);


	

transform


:

 

translateY


(-2
px
);




}
83
.25

 

%
{
-webkit-transform


:

 

translateY


(1
px
);


	

transform


:

 

translateY


(1
px
);




}
100%
{
-webkit-transform




:


 


translateY




(0);
transform




:


 


translateY




(0);
}
}
.bounce {
	animation-name: bounce-animation;
	animation-duration: 2s;
}

.hideDiv {
	display: none;
}

.displayDiv {
	display: block;
}

/*everything below here is just setting up the page, so dont worry about it */
@media ( min-width : 768px) {
	body {
		background-color: blue;
		font-weight: 600;
		text-align: center !important;
		color: black;
	}
	.page-title {
		opacity: .75 !important;
	}
}
</style>
<script>
	$(function() {
		var str = '#len'; //increment by 1 up to 1-nelemnts
		$(document).ready(function() {
			var i, stop;
			i = 1;
			stop = 4; //num elements
			setInterval(function() {
				if (i > stop) {
					return;
				}
				$('#len' + (i++)).toggleClass('bounce');
			}, 500)
		});
	});
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

</head>

<body style="background-color: #fff;">

	<div class="container">



		<form method="POST" target="_blank" action="testServlet">

			<br>

			<div align=center class="form-group mt-3">
				<textarea rows="20" cols="130" name="code" style="background-color: #111; color: #fff; padding: 10px; font-family: "Courier New", arial;" required></textarea>
			</div>
			<hr>

			<select id="selectOption" name="selectFactor" onchange="setDiv()"
				required hidden>
				<option value="coupling">Coupling Factor</option>
			</select>
			
			<hr>

			<div style="margin: auto; width: 600px"
				id="couplingFactor">
				<br>
				<h5 align="center">Weight Related To The Coupling Factor</h5>
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>Coupling Type</th>
							<th>Weight</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>A recursive call</td>
							<td><select class="form-control" name="recursive">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
							</select></td>
						</tr>
						<tr>
							<td>A regular method calling another regular method in the
								same file</td>
							<td><select class="form-control" name="regularRegular">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
							</select></td>
						</tr>
						<tr>
							<td>A regular method calling another regular method in a
								different file</td>
							<td><select class="form-control">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
							</select></td>
						</tr>
						<tr>
							<td>A regular method calling a recursive method in the same
								file</td>
							<td><select class="form-control" name="regularRecursive">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
							</select></td>
						</tr>
						<tr>
							<td>A regular method calling a recursive method in a
								different file</td>
							<td><select class="form-control">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
							</select></td>
						</tr>
						<tr>
							<td>A recursive method calling another recursive method in
								the same file</td>
							<td><select class="form-control" name="recursiveRecursive">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
							</select></td>
						</tr>
						<tr>
							<td>A recursive method calling another recursive method in a
								different file</td>
							<td><select class="form-control">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
							</select></td>
						</tr>
						<tr>
							<td>A recursive method calling a regular method in the same
								file</td>
							<td><select class="form-control" name="recursiveRegular">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
							</select></td>
						</tr>
						<tr>
							<td>A recursive method calling a regular method in a
								different file</td>
							<td><select class="form-control">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
							</select></td>
						</tr>
						<tr>
							<td>A regular method referencing a global variable in the
								same file</td>
							<td><select class="form-control" name="regularGlobal">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
							</select></td>
						</tr>
						<tr>
							<td>A regular method referencing a global variable in a
								different file</td>
							<td><select class="form-control">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
							</select></td>
						</tr>
						<tr>
							<td>A recursive method referencing a global variable in the
								same file</td>
							<td><select class="form-control" name="recursiveGlobal">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
							</select></td>
						</tr>
						<tr>
							<td>A recursive method referencing a global variable in a
								different file</td>
							<td><select class="form-control">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
							</select></td>
						</tr>
					</tbody>
				</table>
			</div>


			<button type="submit" class="btn btn-primary" value="By Control">Run</button>

		</form>

	</div>


</body>
</html>
<script>
	function setDiv() {
		var div = document.getElementById('selectOption').value;

		if (div == "size") {
			hideAll();
			document.getElementById('sizeFactor').classList.add("displayDiv");
		} else if (div == "variable") {
			hideAll();
			document.getElementById('variableFactor').classList
					.add("displayDiv");
		} else if (div == "method") {
			hideAll();
			document.getElementById('methodFactor').classList.add("displayDiv");
		} else if (div == "controlStructure") {
			hideAll();
			document.getElementById('structureFactor').classList
					.add("displayDiv");
		} else if (div == "inheritance") {
			hideAll();
			document.getElementById('inheritanceFactor').classList
					.add("displayDiv");
		} else if (div == "coupling") {
			hideAll();
			document.getElementById('couplingFactor').classList
					.add("displayDiv");
		} else if (div == "all") {
			hideAll();
		} else {
			hideAll();
		}
	}

	function hideAll() {

		document.getElementById('sizeFactor').classList.remove("displayDiv");
		document.getElementById('variableFactor').classList
				.remove("displayDiv");
		document.getElementById('methodFactor').classList.remove("displayDiv");
		document.getElementById('structureFactor').classList
				.remove("displayDiv");
		document.getElementById('inheritanceFactor').classList
				.remove("displayDiv");
		document.getElementById('couplingFactor').classList
				.remove("displayDiv");

		document.getElementById('sizeFactor').classList.add("hideDiv");
		document.getElementById('variableFactor').classList.add("hideDiv");
		document.getElementById('methodFactor').classList.add("hideDiv");
		document.getElementById('structureFactor').classList.add("hideDiv");
		document.getElementById('inheritanceFactor').classList.add("hideDiv");
		document.getElementById('couplingFactor').classList.add("hideDiv");

	}
</script>