<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../style/bootsrtap.min.css">
  <script src="../style/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Inheritance| CDE Solutions</title>
</head>
<body style="background-color: #fff;">

<br>
<div class="container">
<div>
	<img src="../img/logoe.png" style="max-height:75px"/>
	<text style="font-size:30px; color:gray ; margin-left:30px">Inheritance<text>
	<button type="button" class="btn btn-info btn-lg"style="background-color:transparent;float:right; margin-top:30px ;margin-left:30px"><img src="print.png" style="max-height:40px;max-width=:40px;"></button>
	 <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" style="float:right; margin-top:30px;">View Keywords</button>
		<hr/>
	</div>   
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
			    <tr>
			      <th scope="row">1</th>
			      <td>-</td>
			      <td>-</td>
			      <td>-</td>
			      <td>-</td>
			      <td>-</td>
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
				List of keywords..
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