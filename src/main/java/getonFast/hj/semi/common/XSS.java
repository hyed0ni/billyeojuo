package getonFast.hj.semi.common;

public class XSS {
	// 크로스 사이트 스크립트 공격을 방지하기 위한 메소드
	public static String replaceParameter(String parameter) {
		
		if (parameter != null) {
			// 1. XSS 방지 처리
			parameter = parameter.replaceAll("&", "&amp;");
			parameter = parameter.replaceAll("<", "&lt;");
			parameter = parameter.replaceAll(">", "&gt;");
			parameter = parameter.replaceAll("\"", "&quot;");
			
			// 2-2) 개행 문자 -> <br> 태그로 변경
			parameter = parameter.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
			
		}
		
		return parameter;
	}
	
}
