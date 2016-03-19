(function($, globals) { //Module starts
	$(document).ready(function() {
		
		//Make this functions visible outside module
		globals.getTextJson = function getTextJson () {
			return textJson["welcomePhrase"];
		}
	
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

	});
})(jQuery, window)//Module ends