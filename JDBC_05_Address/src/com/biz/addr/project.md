# 주소록 프로젝트

* 오라클의 tbl_addr 테이블을 참조하여 주소록 프로젝트 수행
* base package : com.biz.addr
* ~.persistence : AddrDTO 클래스

* ~.dao : AddrDao 클래스
  dbConnection 부분
  selectAll();
  findById(long id);
  findByName(String name);
  findByTel(String tel);
  findByChain(String chain);
  
  insert(DTO dto);
  delete(long id);
  update(DTO dto)

* ~.service : AddrServiceV1 클래스
  main()에서 호출되는 method 들 생성
    
  
* 오라클 DBMS에 접속하기 위해 ojdbc를 설정
* lombok을 설정

* Test를 위하여 ~.exec : AddrEx_**



  
