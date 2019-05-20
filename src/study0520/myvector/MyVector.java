package study0520.myvector;

public class MyVector {
	private Object[] objArr;
	private int size;	//실제 객체가 저장되있는 개수 .

	MyVector(int capacity) {
		objArr = new Object[capacity];
		size = 0;
	}

	MyVector() {
		this(16);
	}

	int size() {
		return this.size;
	}

	int capacity() {
		return objArr.length;
	}

	boolean isEmpty() {
		return size == 0 ? true : false;
	}

	
	// 먼저 실객체의 수인 size가 배열의 길이인 capacity보다 같거다 크면 
	// objArr.length의 두 배의 길이를 갖는 배열 temp 생성하고
	// objArr이 갖고있는 요소들을 temp배열에 복사한다.
	// 마지막으로 objArr = temp 하여 배열을 가리키는 주소값을 objArr이 갖게한다.
	// temp는 이제 필요없으므로 null해준다?
	// for문을 이용해서 저장된 요소가 null인지 확인한 후에 해당인덱스 위치에 obj를 넣어준다.
	void add(Object obj) {
		if(size >= capacity()) {	//먼저 실객체 수인 size와 배열의 길이인 capacity를 비교해서 실객체수가 같거나 크
			Object[] temp = new Object[objArr.length * 2];	//원래 배열보다 2배 큰 배열을 새로 생성한다.
			System.arraycopy(objArr, 0, temp, 0, objArr.length);	//원래 배열에 저장되있는 요소를 새로 만든 배열에 복사한다.
			objArr = temp;								//마지막으로 원래배열을 가리키고있던 참조변수를 새로만든 배열 주소를 가리키게 한다.
			temp = null;
		}
		for (int i = 0; i < objArr.length; i++) {	//obj의 길이(capacity)만큼 for문을 돌린
			if (objArr[i] == null) {
				objArr[i] = obj;			//해당 인덱스의 위치에 있는 요소가 null이라면 그 위치에 요소저장.
				break;
			}
		}
		size++;							//add되었으므로 size++해준다.
	}

	// 해당 인덱스에 저장된 컬렉션의 객체를 리턴해준다.
	Object get(int index)  {
		return objArr[index];
	}
	
	//objArr에 저장된 모든 객체를 문자열로 이어서 반환.
	//String은 불변객체이므로 계속 반복해서 생성된다.
	//따라서 가변객체인 StringBuffer사용.
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < size; i++) {
			if(i != size-1) {
				sb.append("["+objArr[i]+"], ");
			}else if(i == size-1) {
				sb.append("["+objArr[i]+"]");
			}
		}
		return sb.toString();
	}
	//for문을 사용해 obj와 같은 객체가 저장되있는  인덱스를 반환한다. 못찾으면 -1반환.
	int indexOf(Object obj) {
		int index = -1;
		for(int i = 0; i < objArr.length; i++) {
			if(objArr[i] != null && objArr[i].equals(obj)) {
				index = i;
			}
		}
		
		return index;
	}
	//매개변수로 넘어온 obj가 objArr[i]와 같다면 null로 삭제한다.
	//삭제된다면 해당 인덱스에 위치한 요소는 null이 되고, 그 다음 위치부터 끝값까지 한칸씩 당겨줘야한다.
	// 그럼 배열  마지막 위치에 저장된 요소와 마지막위치 -1 에 위치한 요소가 중복되니 
	//마지막위치에 있는 요소를 null로 준다. 
	boolean remove(Object obj) {
		boolean isRemoved = false;		//삭제가 되었는지 확인하는 변수. 기본값은 false로 준다.
		int index = indexOf(obj);		//indexOf로 obj가 위치한 인덱스를 반환받는다.
		if(index > -1) {				//인덱스가 -1 초과여야 해당 객체가 존재한다는 뜻
			objArr[index] = null;		//해당 인덱스에 있는 요소를 null로 삭제해준다.
			isRemoved = true;			//삭제가 되었으므로 isRemoved = true.
			
			System.arraycopy(objArr, index+1, objArr, index, size-index-1);
//			System.arraycopy(src, srcPos, dest, destPos, length);
			//				src[srcPos]에서 dest[destPos]로 legnth개의 데이터를 복사한다.
			objArr[size-1] = null;
			size--;
		}
		//
//		else if(index == size - 1) {
//			objArr[index] = null;
//			isRemoved = true;
//		}
		
		return isRemoved;
	}
}
