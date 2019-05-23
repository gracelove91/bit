package study0522.AnnotationEx5;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;

@Deprecated
@SuppressWarnings("1111")	//유효하지않은애너테이션은 무시된다.
@TestInfo( testedBy = "eunmo", testDate= @DateTime(yymmdd="190522", hhmmss="235959") )
public class AnnotationEx5 {
	public static void main(String[] args) {
		
		 
		//AnotationEx5 Class 객체를 얻는다.
		Class<AnnotationEx5> cls = AnnotationEx5.class;
		
		TestInfo anno = (TestInfo)cls.getAnnotation(TestInfo.class);
		System.out.println("anno.testedBy() = "+anno.testedBy());
		System.out.println("anno.testDate().yymmdd() = "+ anno.testDate().yymmdd());
		System.out.println("anno.testDate().hhmmss() = "+ anno.testDate().hhmmss());
		
		for(String str : anno.testTools()) {
			System.out.println("testTool = "+str);
		}
		
		System.out.println();
		
		//AnnotationEx5	에 적용된 모든 애너테이션을 가져온다.
		Annotation[] annoArr = cls.getAnnotations();
		
		for(Annotation a : annoArr) {
			System.out.println(a);
		}
	}
}
@Retention(RetentionPolicy.RUNTIME)	//실행시에 사용가능하도록 지정한다.
@interface TestInfo{
	int 		count() 			default 1;
	String 		testedBy();
	String[] 	testTools()			default "JUnit";
	TestType	testType()			default TestType.FIRST;
	DateTime    testDate();
}

@Retention(RetentionPolicy.RUNTIME)//실행시에 사용가능하도록 지정한다.
@interface DateTime{
	String yymmdd();
	String hhmmss();
}

enum TestType { FIRST, FINAL }