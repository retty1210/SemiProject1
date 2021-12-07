window.addEventListener("load",function(){
	var content_box_length = document.getElementsByClassName("content-box").length;
	for(var e = 0; e < content_box_length;e++){
		var content = document.getElementsByClassName("content-box")[e].children.length;
		
		if(content > 3){
			var next_div = document.createElement("div");
			document.getElementsByClassName("content-box")[e].after(next_div);
			var content_box = document.getElementsByClassName("content-box")[e].nextSibling;
			content_box.setAttribute("class","content-box");
		}
	}
});