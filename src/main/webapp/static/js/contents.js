	function imgSize(which){ // name으로 작동하는 function이기 때문에 name값이 없으면 작동하지 않습니다
		var width = eval("document."+which+".width");
		var height = eval("document."+which+".height");
		var max_width= 800;   // 이미지의 가로 최대 크기 : css에서 .contents-imgarea에 있는 width값과 똑같이 맞추어야 작동이 잘 됩니다    
		var max_height = 500; // 이미지의 세로 최대 크기 : 이것도 css의 height값과 맞춰주세요
    	
		if ( width > height && width > max_width ) {  // 이미지가 max_width보다 크다면 너비를 max_width으로 맞추고 비율에 맞춰 세로값을 변경
       	 		height = height/(width / max_width);
        		eval("document."+which+".width = max_width");     
        		eval("document."+which+".height = height");
        		width = max_width;     
    		}
 
		//저도 이유를 설명은 못 하겠으나 else if문으로 바꾸면 function이 아예 작동하질 않습니다. 반드시 if문 두개인 상태 그대로 유지해주세요

			if( height > width && height > max_height ) {  // 이미지가 max_height보다 크다면 높이를 max_height으로 맞추고 비율에 맞춰 가로값을 변경
    	   		width = width/(height / max_height);
        		eval("document."+which+".width = width");
        		eval("document."+which+".height = max_height");
    		}
		}
	