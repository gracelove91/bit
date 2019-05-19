package test;

public class ExceptionTest {
	public static void main(String[] args) {
		method();
	}

	static void method() {
		new InvalidNumberException("InvalidNumberException 발생");
		new NotANumberException("NotANumberException 발생");
	}
}

class NumberException extends Exception {
	NumberException(String msg) {
		super(msg);
	}
}

class InvalidNumberException extends NumberException {
	InvalidNumberException(String msg) {
		super(msg);
	}
}

class NotANumberException extends NumberException {
	NotANumberException(String msg) {
		super(msg);
	}
}
