<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

        <script type="text/javascript">
                function send( f ){
                        
                        var title = f.title.value;
                        var photo1 = f.photo[0].value;
                        var photo2 = f.photo[1].value;
                        
                        if( title == '' ){
                                alert("제목을 입력하세요");
                                f.title.focus();
                                return;
                        }
                        
                        if( photo1 == '' ){
                            alert("전송할 사진을 선택하세요");
                            return;
                        }
                        if( photo2 == '' ){
                            alert("전송할 사진을 선택하세요");
                            return;
                    	}
                        
                        f.action = "upload2";
                        f.submit();
                        
                }//send()
        </script>

</head>
<body>

        <div align="center">
                <!-- 파일업로드를 위해서는 반드시 POST타입으로 전송해야 하며, enctype이 필요하다 -->
                <form method="POST" enctype="multipart/form-data">
        
        				<!-- 
        					jsp의 경우 파라미터의 name을 다르게 해야 보낼 수 있다.
        					spring의 경우는 반드시 파라미터 명을 동일하게 적어야 한다.
        					배열로써 처리됨
        				 -->
                        제목:<input name="title"><br>
                        사진1:<input type="file" name="photo"><br>
                        사진2:<input type="file" name="photo"><br>
                        <input type="button" value="전송" onclick="send(this.form);">
        
                </form>
        </div>
        
</body>
</html>