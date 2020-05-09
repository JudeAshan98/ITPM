
function clearAll() {
	document.getElementById('cont_res').value = '';
	document.getElementById('inh_res').value = '';
	// document.getElementById('svm_res').value = '';
	document.getElementById('couple_res').value = '';
	document.getElementById('summary_res').value = '';
	window.location.reload(false);
}

function checkExt(filename) {

	// Get the file extention.
	var fileExtension = filename.substr((filename.lastIndexOf('.') + 1));
	console.log(fileExtension);
	sessionStorage.setItem("Ext", fileExtension);
	document.getElementById("CExtention").value = sessionStorage.getItem("Ext");
	document.getElementById("IExtention").value = sessionStorage.getItem("Ext");
	// document.getElementById("CpExtention").value =
	// sessionStorage.getItem("Ext");
	// document.getElementById("SExtention").value =
	// sessionStorage.getItem("Ext");
	// document.getElementById("VExtention").value =
	// sessionStorage.getItem("Ext");
	// document.getElementById("MExtention").value =
	// sessionStorage.getItem("Ext");
	// Check the file type.. Should only support for .java and .cpp files only.
	if (fileExtension == 'java') {
		// editor.session.setMode("ace/mode/java");
		// alert("I am JAVA!")
	} else if (fileExtension == 'cpp') {
		// editor.session.setMode("ace/mode/c_cpp");
		// alert("I am c++!");
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
		div.innerHTML = name + "____" + '\n' + '\n' + text + '\n' + '\n';
		output.appendChild(div);
	}
	reader.readAsText(file, "UTF-8");
	console.log("Output is" + output.textContent);
	sessionStorage.setItem("Result", output.textContent);
	document.getElementById("cont_res").value = sessionStorage.getItem("Result");
}

