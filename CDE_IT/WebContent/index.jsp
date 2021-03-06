<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>CDE CODE EXTRACTOR</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="style/bootsrtap.min.css">
<script src="style/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js">
	
</script>

<!--  <script>
  document.getElementById("cont_res").innerHTML = sessionStorage.getItem("Result");
  document.getElementById("inh_res").innerHTML = sessionStorage.getItem("Result");
  document.getElementById("svm_res").innerHTML = sessionStorage.getItem("Result");
  document.getElementById("couple_res").innerHTML = sessionStorage.getItem("Result");
  document.getElementById("summary_res").innerHTML = sessionStorage.getItem("Result");
</script> -->

<style>
<!--
body {
	background-color: white;
	padding: 50px 50px
}

-->
pre {
	background-color: black;
	overflow: auto;
	margin: 0 0 1em;
	padding: .5em 1em;
}

pre code, pre .line-number {
	/* Ukuran line-height antara teks di dalam tag <code> dan <span class="line-number"> harus sama! */
	font: normal normal 12px/14px "Courier New", Courier, Monospace;
	color: white;
	display: block;
}

pre .line-number {
	user-select: none;
	float: left;
	margin: 0 1em 0 -1em;
	border-right: 1px solid;
	text-align: right;
}

pre .line-number span {
	display: block;
	padding: 0 .5em 0 1em;
}

pre .cl {
	display: block;
	clear: both;
}

.vl {
	border-left: 1px solid gray;
	height: 40px;
}
</style>



<script>
	// function updateSize() {
	//   let nBytes = 0,
	//       oFiles = document.getElementById("uploadInput").files,
	//       nFiles = oFiles.length;
	//   for (let nFileId = 0; nFileId < nFiles; nFileId++) {
	//     nBytes += oFiles[nFileId].size;
	//   }
	//   let sOutput = nBytes + " bytes";
	//   // optional code for multiples approximation
	//   const aMultiples = ["KiB", "MiB", "GiB", "TiB", "PiB", "EiB", "ZiB", "YiB"];
	//   for (nMultiple = 0, nApprox = nBytes / 1024; nApprox > 1; nApprox /= 1024, nMultiple++); {
	//     sOutput = nApprox.toFixed(3) + " " + aMultiples[nMultiple] + " (" + nBytes + " bytes)";
	//   }
	//   // end of optional code
	// //  document.getElementById("fileNum").innerHTML = nFiles;
	//   document.getElementById("fileSize").innerHTML = sOutput;
	// }
</script>


</head>

<body>
	<div class="container">
		<!-- <div class="row"> -->
		<div>
			<!-- <p>CDE IT Solutions</p> -->
			<img src="img/logoe.png"
				style="max-height: 75px; width: 141px; height: 81px" />
			<hr />
		</div>
		<div class="row">
			<div class="col">
				<div class="custom-file">
					<input type="file" class="custom-file-input" id="myFile"
						onchange="updateSize"> <label class="custom-file-label"
						for="customFile">Choose file</label>
				</div>
			</div>
			<div class="col-md-auto">
				<input type="button" class="btn btn-success" id="newFile"
					onclick="clearAll()" value="New *"></input>
			</div>
			<div class="col-md-auto">
				<div class="vl">
					&nbsp &nbsp <a><img src="img/green-settings.png"
						style="height: 40px; width: 40px" id="settings_btn"></a>
				</div>
			</div>
		</div>

		<hr>
		<form id="myF">
			<pre>
				<code>
					<div id="output" style="max-height: 650px; height: 500px">
</div>
			
			</pre>
		</form>
		<script>
			var input = document.getElementById("myFile");
			var output = document.getElementById("output");

			input
					.addEventListener(
							"change",
							function() {
								if (this.files && this.files[0]) {
									var myFile = this.files[0];
									var reader = new FileReader();
									document.getElementById('myF').reset();
									reader
											.addEventListener(
													'load',
													function(e) {
														var pre = document
																.getElementsByTagName('pre'), pl = pre.length;
														for (var i = 0; i < pl; i++) {
															output.textContent = e.target.result;
															pre[i].innerHTML = '<span class="line-number"></span>'
																	+ pre[i].innerHTML
																	+ '<span class="cl"></span>';
															var num = pre[i].innerHTML
																	.split(/\n/).length;
															for (var j = 0; j < num; j++) {
																var line_num = pre[i]
																		.getElementsByTagName('span')[0];
																line_num.innerHTML += '<span>'
																		+ (j + 1)
																		+ '</span>';

															}
															   sessionStorage.setItem("Result", output.textContent);
															   document.getElementById("cont_res").value = sessionStorage.getItem("Result");
															   //document.getElementById("cont_res").value = "Jude";
															   document.getElementById("inh_res").value = sessionStorage.getItem("Result");
															   document.getElementById("svm_res").value = sessionStorage.getItem("Result");
															   document.getElementById("couple_res").value = sessionStorage.getItem("Result");
															   document.getElementById("summary_res").value = sessionStorage.getItem("Result");
														}

													});

									reader.readAsBinaryString(myFile);
									input.setAttribute("disabled", true);

								}
								var file = input.files[0];
								var filename = file.name;
								// Get the file extention.
								var fileExtension = filename.substr((filename
										.lastIndexOf('.') + 1));
								console.log(fileExtension);

								// Check the file type.. Should only support for .java and .cpp files only.
								if (fileExtension == 'java') {
									//	editor.session.setMode("ace/mode/java");
									//	alert("I am JAVA!")
								} else if (fileExtension == 'cpp') {
									//editor.session.setMode("ace/mode/c_cpp");
									//	alert("I am c++!");
								} else {
									alert("Invalid file format, Please select java or c++ file!");
									window.location.reload(false);
								}

							});
		</script>
		<script>
			// Add the following code if you want the name of the file appear on select
			$(".custom-file-input").on(
					"change",
					function() {
						var fileName = $(this).val().split("\\").pop();
						$(this).siblings(".custom-file-label").addClass(
								"selected").html(fileName);
					});
		</script>
		<div class="row">&nbsp &nbsp
			<form method="post" action="SVM_serv" accept-charset=utf-8>
				<button type="Submit" id="svm_btn" class="btn btn-primary btn-lg"
					style="padding: 15px; width: 160px; height: 100px">SVM</button>&nbsp<div id = "svm_res" hidden></div>
			</form>
			<form method="post" action="Inheritance_serv" accept-charset=utf-8>
			<button type="Submit" id="inheritance_btn"
				class="btn btn-primary btn-lg"
				style="padding: 15px; width: 160px; height: 100px">Inheritance</button>&nbsp<div id = "inh_res" hidden></div>
			</form>
			<form method="post" action="Coupling_serv" accept-charset=utf-8>
			<button type="Submit" id="coupling_btn"
				class="btn btn-primary btn-lg"
				style="padding: 15px; width: 160px; height: 100px">Coupling</button>&nbsp <div id = "couple_res" hidden></div>
			</form>
			<form method="post" action="ControlStr_serv" accept-charset=utf-8> 
				<textarea id = "cont_res" name = "cont_res" style="width:30%;Height:30%" hidden></textarea>
			<button type="Submit" id="control_btn" class="btn btn-primary btn-lg"
				style="padding: 15px; width: 160px; height: 100px">Control
				Structures</button>&nbsp
			</form> 
			<form method="post" action="Summary_serv" accept-charset=utf-8>
			<button type="Submit" id="summary_btn" class="btn btn-success btn-lg"
				style="padding: 45px; height: 100px">Summary</button>&nbsp <div id = "summary_res" hidden></div>
			</form>
		</div>
		<div style="float: right; margin-top: -99px;">
			<div>
				Imported File Detail(s):<br />
				<textarea id="fileSize" readonly></textarea>
			</div>
		</div>

	</div>

	<script>
		function clearAll() {
			window.location.reload(false);
		}

</body>
</html>