<html>
<head>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="js/showJson.js"></script>
	<script>
	$(document).ready(function () {
		$(showText).html(getTextJson());
	});
	</script>
</head>
<body>
	<h2>RESTful Web Application!</h2>
	<p><a href="webresources/myresource">Click resource</a>
	<p><a href="webresources/myresource/ejb">Click EJB resource</a>
	<div id="showText"></div>

</body>
</html>
