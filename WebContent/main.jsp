<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	    		
	    		location.href="index.do?cmd=insert&todo="+thingToDo;
 					alert("추가되었습니다.");
 					$("#thingToDo").val("");
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
      	<c:if test="${ empty toDoList }">
      		<tr>
      			<td colspan="4" align="center">조회된 결과가 없습니다.</td>
      		</tr>
      	</c:if>
      	<c:forEach items="${ toDoList }" var="toDo">
      		<tr onclick="location.href='main.do?cmd=update&td_num='+'${ toDo.td_num }';">
      			<td><c:out value="${ toDo.content }"/></td>
      			<td>미완료<input type="hidden" value="${ toDo.td_num }"/></td>
      			<td><c:out value="${ toDo.input_date }"/></td>
      			<td><a href="main.do?cmd=delete&td_num=${ toDo.td_num }">삭제</a></td>
      		</tr>
      	</c:forEach>
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
      	<c:if test="${ empty finishedList }">
      		<tr>
      			<td colspan="4" align="center">조회된 결과가 없습니다.</td>
      		</tr>
      	</c:if>
      	<c:forEach items="${ finishedList }" var="finishedToDo">
      		<tr>
      			<td><c:out value="${ finishedToDo.content }"/></td>
      			<td>완료</td>
      			<td><c:out value="${ finishedToDo.input_date }"/></td>
      			<td><a href="main.do?cmd=delete&td_num=${ finishedToDo.td_num }">삭제</a></td>
      		</tr>
      	</c:forEach>
      	</tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>
