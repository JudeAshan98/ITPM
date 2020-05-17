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

#myF {
	max-height: 650px;
	max-height: 500px;
	overflow: auto;
}

#output {
	height: 400px;
	
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
					<input type="file" class="custom-file-input" id="myFile" multiple>
					<label class="custom-file-label" for="customFile">Choose
						file</label>
				</div>
			</div>
			<div class="col-md-auto">
				<input type="button" class="btn btn-success" id="newFile"
					onclick="clearAll()" value="New *"></input>
			</div>
			<div class="col-md-auto">
				<div class="vl">
					<form action="Settings_serv" method="post">
						&nbsp &nbsp
						<button type="submit"
							style="border: none; padding: 0; background: none;">
							<img src="img/green-settings.png"
								style="height: 40px; width: 40px" id="settings_btn">
						</button>
					</form>
				</div>
			</div>
		</div>

		<hr>
		<form id="myF">
			<pre>
				<code>
					<div id="output">
</div>
				</code>
			
			</pre>
		</form>
<br>
		<div class="row" style="padding-left: 100px;">
			&nbsp &nbsp
			<form method="post" action="Size_serv" accept-charset=utf-8>
				<input type="text" name="SExtention" id="SExtention" hidden>
				<textarea id="size_res" name="size_res"
					style="width: 30%; Height: 30%" hidden></textarea>
				<button type="Submit" id="size_btn" class="btn btn-primary btn-lg"
					style="padding: 15px; width: 140px; height: 100px">Size</button>
				&nbsp
			</form>

			<form method="post" action="Method_serv" accept-charset=utf-8>
				<input type="text" name="MExtention" id="MExtention" hidden>
				<textarea id="method_res" name="method_res"
					style="width: 30%; Height: 30%" hidden></textarea>
				<button type="Submit" id="method_btn" class="btn btn-primary btn-lg"
					style="padding: 15px; width: 140px; height: 100px">Method</button>
				&nbsp
			</form>

			<form method="post" action="Variable_serv" accept-charset=utf-8>
				<input type="text" name="VExtention" id="VExtention" hidden>
				<textarea id="variable_res" name="variable_res"
					style="width: 30%; Height: 30%" hidden></textarea>
				<button type="Submit" id="size_btn" class="btn btn-primary btn-lg"
					style="padding: 15px; width: 140px; height: 100px">Variable</button>
				&nbsp
			</form>
			<form method="post" action="Inheritance_serv" accept-charset=utf-8>
				<textarea id="inh_res" name="inh_res"
					style="width: 30%; Height: 30%" hidden></textarea>
				<input type="text" name="IExtention" id="IExtention" hidden>
				<button type="Submit" id="inheritance_btn"
					class="btn btn-primary btn-lg"
					style="padding: 15px; width: 140px; height: 100px">Inheritance</button>
				&nbsp
				<div id="inh_res" hidden></div>
			</form>
			<form method="post" action="Coupling_serv" accept-charset=utf-8>
				<!-- <input type="text" name="VExtention" id="VExtention" hidden> -->
				<textarea id="couple_res" name="couple_res"
					style="width: 30%; Height: 30%" hidden></textarea>
				<button type="Submit" id="coupling_btn" class="btn btn-primary btn-lg"
					style="padding: 15px; width: 140px; height: 100px">Coupling</button>
				&nbsp
			</form>
			<!-- <form method="post" action="Coupling_serv" accept-charset=utf-8>
				<button type="Submit" id="coupling_btn"
					class="btn btn-primary btn-lg"
					style="padding: 15px; width: 140px; height: 100px">Coupling</button>
				&nbsp
				<div id="couple_res" hidden></div>
			</form> -->
			<form method="post" action="ControlStr_serv" accept-charset=utf-8>
				<textarea id="cont_res" name="cont_res"
					style="width: 30%; Height: 30%" hidden></textarea>
				<input type="text" name="Extention" id="CExtention" hidden>
				<button type="Submit" id="control_btn"
					class="btn btn-primary btn-lg"
					style="padding: 15px; width: 140px; height: 100px">Control
					Structures</button>
				&nbsp
			</form>
			<!-- <form method="post" action="Summary_serv" accept-charset=utf-8>
				<button type="Submit" id="summary_btn"
					class="btn btn-success btn-lg" style="padding: 45px; height: 100px">Summary</button>
				&nbsp
				<div id="summary_res" hidden></div>
			</form> -->
		</div>
		<br />
		<div style="float: right; margin-top: -10px;">
			<div>
				Imported File Detail(s):<br />
				<textarea id="fileSize" readonly></textarea>
			</div>
		</div>

	</div>

	<script>
		function clearAll() {
			document.getElementById('cont_res').value = '';
			document.getElementById('inh_res').value = '';
			//		document.getElementById('svm_res').value = '';
			document.getElementById('couple_res').value = '';
// 			document.getElementById('summary_res').value = '';
			window.location.reload(false);
		}

		function checkExt(filename) {

			// Get the file extention.
			var fileExtension = filename
					.substr((filename.lastIndexOf('.') + 1));
			console.log(fileExtension);
			sessionStorage.setItem("Ext", fileExtension);
			document.getElementById("CExtention").value = sessionStorage
					.getItem("Ext");
			document.getElementById("IExtention").value = sessionStorage
					.getItem("Ext");
			//				document.getElementById("CpExtention").value = sessionStorage.getItem("Ext");
			document.getElementById("SExtention").value = sessionStorage
					.getItem("Ext");
			document.getElementById("VExtention").value = sessionStorage
					.getItem("Ext");
			document.getElementById("MExtention").value = sessionStorage
					.getItem("Ext");
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

		}

		function reacfilecontent(file) {
			var name = file.name;
			var reader = new FileReader();
			var output = document.getElementById("output");
			reader.onload = function(e) {
				// get file content  
				var text = e.target.result;
				var div = document.createElement("div");
				div.innerHTML = '________' + name + "__________" + '\n' + '\n'
						+ text + '\n' + '\n';
				output.appendChild(div);

				// Store the file content in a session variable.
				sessionStorage.setItem("Result", output.textContent);

				//Send file content to each function 
				document.getElementById("cont_res").value = sessionStorage
						.getItem("Result");
				document.getElementById("inh_res").value = sessionStorage
						.getItem("Result");
				document.getElementById("size_res").value = sessionStorage
						.getItem("Result");
				document.getElementById("method_res").value = sessionStorage
						.getItem("Result");
				document.getElementById("variable_res").value = sessionStorage
						.getItem("Result");
				document.getElementById("couple_res").value = sessionStorage
						.getItem("Result");
// 				document.getElementById("summary_res").value = sessionStorage
// 						.getItem("Result");

			}
			reader.readAsText(file, "UTF-8");

		}
	</script>
	<script>
		var input = document.getElementById("myFile");
		var filelist = new Array();
		var file_next = '';
		input.addEventListener("change", function() {
			document.getElementById('myF').reset();

			for (var a = 0; a < input.files.length; ++a) {
				reacfilecontent(input.files[a]); // Read File content
				checkExt(input.files.item(a).name); // Check file the extention
				filelist[a] = a + 1 + ') ' + input.files.item(a).name + '\n'; // get file name details
				fileSize.innerHTML = filelist;
			}
		});

		$("pre code").each(function() {
			var html = $(this).html();
			var pattern = html.match(/\s*\n[\t\s]*/);
			$(this).html(html.replace(new RegExp(pattern, "g"), '\n'));
		});
	</script>

</body>
</html>