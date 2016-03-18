<html>
<body>
	<h2>RESTful Web Application!</h2>
	<p><a href="webresources/myresource">Click resource</a>
	<p><a href="webresources/myresource/ejb">Click EJB resource</a>
	<div id="showText"></div>

<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
$(document).ready(function() {
	
	var textJson = (function() {
		var json = null;
		$.ajax({
			'async' : false,
			'global' : false,
			'url' : "webresources/myresource",
			'dataType' : "json",
			'success' : function(data) {
				json = data;
			}
		});
		return json;
	})();

	$(showText).html(textJson["welcomePhrase"]);
});
</script>
	
</body>
</html>
