<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Youngs To Do List</title>

    <!-- Bootstrap core CSS -->
		<link href="http://localhost:8080/to_do_list/common/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="http://localhost:8080/to_do_list/common/css/pricing.css" rel="stylesheet">
    
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script type="text/javascript">
    	$(function() {
    		$("#addBtn").click(function() {
	    		var thingToDo = $("#thingToDo").val();
	    		
	    		if (thingToDo == "") {
	    			alert("할 일을 입력해주세요.");
	    			$("#thingToDo").focus();
	    			return;
	    		}
	    		
	    		var url = "index.do";
	    		var queryString = "cmd=insert&thing_to_do="+thingToDo;
    			
    			$.ajax({
    				url:url,
    				data:queryString,
    				dataType:JSON,
    				async:"false",
    				error:function(xhr) {
    					alert("에러코드 : "+xhr.status+", 에러메시지 : "+xhr.statusText);
    				},
    				success:function(result){
    					// JSON 형태로 DB로부터 데이터를 조회해서 가져옴()
    				}
    			});
    		});
    	});
    </script>
    
    
  </head>
  <body>

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
  <h1 class="display-4">Youngs To Do List</h1>
  <p class="lead">할 일들을 기록하세요</p>
</div>

<div class="container">
  <div class="card-deck mb-3 text-center" style="width:300px; margin:0px auto;">
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">새로운 할 일</h4>
      </div>
      <div class="card-body">
      	<div style="margin-bottom:20px;">
      		<input class="form-control" id="thingToDo" type="text" placeholder="할 일을 입력해주세요."/> 
      	</div>
        <button type="button" class="btn btn-lg btn-block btn-primary" id="addBtn">추가</button>
      </div>
    </div>
  </div>
</div>
<br/>
<div class="container col-12">
  <div class="card-deck mb-3 text-center" style="width:700px; margin:0px auto;">
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">해야할 일들</h4>
      </div>
      <table class="table table-hover">
      	<thead>
      		<tr>
      			<th scope="col">내용</th>
      			<th scope="col">완료여부</th>
      			<th scope="col">등록일</th>
      			<th scope="col">삭제</th>
      		</tr>
      	</thead>
      	<tbody>
      		<tr>
      			<td>블라블라블라</td>
      			<td>미완료</td>
      			<td>2019-00-00</td>
      			<td><a href="#" >삭제</a></td>
      		</tr>
      	</tbody>
      </table>
    </div>
  </div>
</div>
<div class="container col-12">
  <div class="card-deck mb-3 text-center" style="width:700px; margin:0px auto;">
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">완료된 일들</h4>
      </div>
      <table class="table table-hover">
      		<thead>
      		<tr>
      			<th scope="col">내용</th>
      			<th scope="col">완료여부</th>
      			<th scope="col">완료일</th>
      			<th scope="col">삭제</th>
      		</tr>
      	</thead>
      	<tbody>
      		<tr>
      			<td>블라블라블라</td>
      			<td>완료</td>
      			<td>2019-00-00</td>
      			<td><a href="#" >삭제</a></td>
      		</tr>
      	</tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>
