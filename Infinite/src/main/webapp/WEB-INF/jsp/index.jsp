<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<!-- Access the bootstrap Css like this, 
		Spring boot will handle the resource mapping automcatically -->
		<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
	<style>
			.myChat {
				float: right;
				padding: 7px;
				background: #ddd;
				color: #000;
				border-radius: 8px;
			}.theirChat {
				float: right;
				padding: 7px;
				background: #369;
				color: #fff;
				border-radius: 8px;
			}
	</style>
</head>
<body onload="init()">

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Unknown</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
			</div>
		</div>
	</nav>

	<div class="container" style="position:fixed;bottom:0;left:10%;">
		<div class="panel panel-default">
			<div class="panel-heading" id="panelHeader"> 
				</div><div class="panel-body" id="panelBody"
				style="overflow: auto; overflow-x: hidden;max-height:700px;">
					<div id="chatContent"></div>
				</div>
			<div class="panel-footer">
				<div class="row">
					<div class="col-lg-11">
						<div class="input-group col-lg-12">
						 	<input type="text" class="form-control" id="input"
								placeholder="">
						</div>
						<!-- /input-group -->
					</div>
					<!-- /.col-lg-6 -->
					<div class="col-lg-1">
						<div class="input-group">
							<input type="button" onclick="send()" class="btn btn-sm btn-primary" value="Send">
						</div>
						<!-- /input-group -->
					</div>
					<!-- /.col-lg-6 -->
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	document.getElementById('input').onkeydown = function(e){
		   if(e.keyCode == 13){
			   send();
		   }
		};
		function init() {
// 			document.getElementById("panelBody").style.height = "400px";
		}
		function send(){
			let text=document.getElementById("input").value;
			append(text, 0);
			document.getElementById("input").value="";
			document.getElementById("input").focus();
			var xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			    	append(this.responseText, 1);
			    }
			  };
			  xhttp.open("GET", "/query?key="+text, true);
			  xhttp.send();
		}
		
		function append(text, align) {
			var el = document.getElementById('chatContent'),
			// Make a new div
			elChild = document.createElement('div');

			if(align===0){
				elChild.style.float='right';
				elChild.className='myChat';
			}
			else{
				elChild.style.float='left';
				elChild.className='theirChat';
			}
			
			// Give the new div some content
			elChild.innerHTML = text;
			
			elChildParent = document.createElement('div');
			elChildParent.style.width="100%";
			elChildParent.style.display="inline-block";
			elChildParent.append(elChild);

			// Jug it into the parent element
			el.append(elChildParent);
			var element = document.getElementById("panelBody");
	        element.scrollTop = element.scrollHeight;
		}
	</script>
	
</body>

</html>
