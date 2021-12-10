var seq;

function writeComment(f) {
	if(confirm("댓글을 등록하시겠습니까?")== false){
		return;
	}

	var url = "writeComment";
	
	// 한글, 특수문자가 들어가 있을 경우를 대비해서 인코딩해서 보낸다.
	var param = "board_no=" + encodeURIComponent(f.board_no.value) + "&id="+encodeURIComponent(f.id.value) 
				+ "&content=" + encodeURIComponent(f.content.value);
	
	seq = f.board_no.value;
	sendRequest(url, param, resultFn, "GET");
	
}

function deleteComment(f){
	if(confirm("댓글을 삭제하시겠습니까?") == false){
		return;
	}
	
	var url = "deleteComment";
	var param ="seq="+encodeURIComponent(f.seq.value) + "&board_no=" + encodeURIComponent(f.board_no.value);
	
	seq = f.board_no.value;
	sendRequest(url, param, resultFn, "GET");
	
}

function up(f){
	if(confirm("이 댓글을 공감하시겠습니까?") == false){
		return;
	}
	
	f.up_down.value = 1;
	var url = "recommend";
	var param ="seq="+encodeURIComponent(f.seq.value) + "&id=" + encodeURIComponent(f.id.value) + "&up_down=" + encodeURIComponent(f.up_down.value);
		
	seq = f.board_no.value;
	sendRequest(url, param, resultFn, "GET");
}

function down(f){
	if(confirm("이 댓글을 비공감하시겠습니까?") == false){
		return;
	}
	
	f.up_down.value = -1;
	var url = "decommend";
	var param ="seq="+encodeURIComponent(f.seq.value) + "&id=" + encodeURIComponent(f.id.value) + "&up_down=" + encodeURIComponent(f.up_down.value);
		
	seq = f.board_no.value;
	sendRequest(url, param, resultFn, "GET");
}

function recommendBoard(f){
	if(confirm("이 게시글을 공감하시겠습니까?") == false){
		return;
	}
	
	f.up_down.value = 1;
	var url = "recommendBoard";
	var param ="seq="+encodeURIComponent(f.seq.value) + "&id=" + encodeURIComponent(f.id.value) +  "&up_down=" + encodeURIComponent(f.up_down.value);
		
	seq = f.seq.value;
	sendRequest(url, param, resultFn, "GET");
}

function decommendBoard(f){
	if(confirm("이 게시글을 비공감하시겠습니까?") == false){
		return;
	}
	
	f.up_down.value = -1;
	var url = "decommendBoard";
	var param ="seq="+encodeURIComponent(f.seq.value) + "&id=" + encodeURIComponent(f.id.value) +  "&up_down=" + encodeURIComponent(f.up_down.value);
		
	seq = f.seq.value;
	sendRequest(url, param, resultFn, "GET");
}
	
function resultFn(){
	// 결과를 받을 콜백 메소드
	if(xhr.readyState == 4 && xhr.status == 200){
		var data = xhr.responseText;
		
		if(data == "no"){
			alert('실패');
			return;
		} else if(data == "up") {
			alert('이미 공감했습니다');
			return;
		} else if(data == "down"){
			alert('이미 비공감했습니다');
			return;
		} else {
			alert('성공');
		}
		
		
		location.href="view?seq=" + seq;
	}
}