package enums;
/*
  static은 상수풀에 계속 존재하고 있어 메모리를 잡아먹어 쿼리가 많아지면 그 만큼 실행될 메모리 공간이 좁아진다. 
  enum을 사용하여 static에 사용할 상수를 객체로 만들어 프로그램이 실행될 때만 존재하도록 한다.
  */
public enum MemberQuery {
	INSERT,
	LIST, SELECT, RETRIEVE, COUNT,
	UPDATE,
	DELETE,
	LOGIN;
}