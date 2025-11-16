package behavioral.iterator;

public interface Iterator<E>{
    public abstract boolean hasNext(); //다음 요소의 존재 여부 확인
    public abstract E next(); //다음 요소를 가져옴
}
