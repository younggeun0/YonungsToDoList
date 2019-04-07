# To Do List

* 할일 목록을 저장하는 To Do List 토이 프로젝트
* Bootstrap, MyBatis 사용, Model2 적용

## UI 설계

![04](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/toDoList/04.png?raw=true)

## DB 설계(ERD)

* finish_flag는 DEFAULT 'N'처리
  * 해야할 일 클릭 시 'Y'로 업데이트 처리
* input_date는 DEFAULT SYSDATE
* td_num은 SEQUENCE를 사용한 FUNCTION으로 생성('td_000000')
  
![05](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/toDoList/05.png?raw=true)

## Class Diagram 설계

![06](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/toDoList/06.png?raw=true)

## 시연

![03](https://github.com/younggeun0/younggeun0.github.io/blob/master/_posts/img/toyProjects/toDoList/03.gif?raw=true)
