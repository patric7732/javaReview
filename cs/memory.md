

# 1. 메모리 관리

---

![](https://velog.velcdn.com/images/patric7732/post/f33f1a04-f7cf-439f-a556-81eebc2efaab/image.png)


메모리란?

- 작업을 위해 실행되는 공간, RAM 프로그램 실행 시에 필요한 주소, 정보들을 저장하고 가져올 수 있게 만드는 공간임

메모리에는 크게 논리주소와 물리주소로 나뉨

논리주소 : 프로세스마다 독립적으로 가지는 주소 공간

물리주소 : 메모리가 실제 올라가는 위치

## 1.1 메모리를 효과적으로 관리하는 이유

> 메모리 관리는 컴퓨터 시스템 성능과 안정성에 영향일 미치는 여러가지 이유이기에 필요시하다.
>

1. 성능 최적화
    - 메모리 할당, 취소에 대한 소요 시간을 감소시켜 애플리케이션이 더 빠르게 실행되게 함.
    - 적절한 관리를 통해 메모리 리소스 사용을 극대화하여 스와핑의 필요성을 줄임
2. 안정성과 신뢰성
    - 메모리에 대한 누수를 방지할 수 있으며 메모리에 대한 조각화를 줄임
3. 확장성
    - 큰 대형 데이터를 처리할 수 있고 성능 저하 없이 요구사항을 충족 가능
    - 여러 동시 프로세스의 효율적인 실행을 지원하여 프로세스가 과도한 지연 없이 메모리를 얻게 할 수 있음
4. 비용 효율성
    - 메모리 사용을 최적화 하여 추가 리소스 없이 나은 성능을 달성할 수 있음
    - 과도한 메모리 작업의 필요성을 최소화하여 에너지 소비를 줄임
5. 보안
    - 악의적인 사용자가 무단으로 버퍼 오버플로 및 기타 취약점을 방지해줌
    - 데이터의 무결성을 유지시키고, 데이터 손실 및 손상을 방지함

# 2. 메모리 관리 기법

---

## 2.1 동적 적재 (Dynamic Loading)

- 프로그램이 실행시에 필요한 루틴과 데이터만 메모리에 로드하는 방법, 메모리의 이용률이 향상
- 예를 들어 루틴과 데이터는 항상 사용하지 않고 필요시에만 메모리에 적재가 가능함

## 2.2 동적 연결 (Dynamic Linking)

- 라이브러리 연결을 컴파일 때가 아닌 실행 시간까지 미루는 방법임

## 2.3 스와핑 (Swapping)

- CPU에서 사용하지 않는 부분을 하드디스크에 적재하여 나중에 필요할 때 불러오는 방법임, 사용하지 않으면 하드디스크에 다시 적재하는 방식으로 RAM을 효과적으로 관리

## 2.4 연속 할당 기법

> 실행을 위한 프로세스를 메모리 공간에 인접하여 연속적으로 저장하는 방법
>

연속적으로 할당, 제거를 반복하게 된다면 Scattered Holes가 생겨나 외부 단편화가 생김

이런 외부 단편화를 줄이기 위한 방식으로 메모리 배치 기법이 있다.

- 최초 적합 (First Fit) : 프로세스가 적재될 수 있는 가용 공간 중에서 첫 번째 분할에 할당하는 방식임, 빠른 특징이 있음
- 최적 적합 (Best Fit) : 가용 공간 중에서 가장 크기가 비슷한 공간을 선택하고 프로세스를 적재하는 방식. 공백 최소화의 장점이 있음
- 최악 적합 (Worst Fit) : 프로세스 가용 공간 중 가장 큰 공간에 할당하는 방식임

## 2.5 분산 할당 기법

> 하나의 프로세스를 여러 개의 조각으로 나누어서 메모리의 여러 영역에 분산 배치하는 방법임
>
![](https://velog.velcdn.com/images/patric7732/post/b4582f26-8a01-4e50-ae58-cfbd14832f0a/image.png)

### 2.5.1 페이징 기법

- 메모리 공간이 연속적으로 할당되어야 한다는 제약조건을 없애는 기법임
- 논리 메모리는 고정크기의 페이지, 물리 메모리는 고정크기의 프레임 블록으로 나누어 관리
- 프로세스가 사용하는 공간을 논리 메모리에서 여러 개의 페이지로 나누어 관리하고, 개별 페이지는 순서에 상관없이 물리 메모리에 있는 프레임에 매핑되어 저장
- MMU(Memory Management Unit)의 재배치 레지스터 방식을 활용해 CPU가 마치 프로세스가 연속된 메모리에 할당된 것처럼 인식하도록 함

> Memory-Management Unit (MMU)
>
> - MMU란 논리적인 주소를 물리적인 주소로 매핑해주는 하드웨어이다. (주소변환을 지원해주는 하드웨어이다.)

- 페이징 기법 문제점
    - 스레싱 : 어떤 프로세스가 계속적으로 페이지 부재가 발생하여 프로세스의 실제 처리 시간보다 페이지 교체 시간이 많아지는 현상이며 오류률이 클 수록 스레싱이 많이 발생한 것이고 이로 인해 시스템의 성능, 처리율이 저하. 그리고 페이지 부재가 높아져 기억장치 접근 시간이 증가함

### 2.5.2 세그먼테이션 기법

- 페이징 기법과 반대로 논리 메모리와 물리 메모리를 같은 크기의 블록이 아닌, 서로 다른 크기의 논리적 단위인 세그먼트로 분할
- 외부 단편화 발생

### 2.5.3 페이징/세그멘테이션 혼용기법

- 페이징과 세그멘테이션도 각각 내부 단편화와 외부 단편화가 발생
- 페이징과 세그멘테이션을 혼용해 이러한 단편화를 최대한 줄이는 전략
- 프로세스를 세그먼트(논리적 기능 단위)로 나눈 다음 세그먼트를 다시 페이지 단위로 나누어 관리
- 매핑 테이블을 두 번 거쳐야하므로 속도가 느려짐

# 3. 단편화

---

프로세스를 할당, 반납 과정에서 사용되지 못하고 메모리가 낭비되는 현상

### 3.1 내부 단편화
![](https://velog.velcdn.com/images/patric7732/post/36f2f19a-ef23-46b8-92c1-21cb542b907a/image.png)


- 분할된 공간에 프로세스를 적재한 후 남은 공간
- 고정 분할 할당 방식 또는 페이징 기법 사용 시 발생하는 메모리 단편화

### 3.2 외부 단편화
![](https://velog.velcdn.com/images/patric7732/post/f30b2d66-515d-4f6e-91af-638b1352c900/image.png)


- 할당된 크기가 프로세스 크기보다 작아 사용하지 못하는 공간
- 가변 분할 할당 방식 또는 세그멘테이션 기법 사용 시 발생하는 메모리 단편화

**참고/출처**

[https://dheldh77.tistory.com/entry/운영체제메모리-관리-전략Memory-Management-Strategy](https://dheldh77.tistory.com/entry/%EC%9A%B4%EC%98%81%EC%B2%B4%EC%A0%9C%EB%A9%94%EB%AA%A8%EB%A6%AC-%EA%B4%80%EB%A6%AC-%EC%A0%84%EB%9E%B5Memory-Management-Strategy)
[https://systorage.tistory.com/entry/CS-운영체제-메모리-관리#Memory-Management Unit (MMU)-1](https://systorage.tistory.com/entry/CS-%EC%9A%B4%EC%98%81%EC%B2%B4%EC%A0%9C-%EB%A9%94%EB%AA%A8%EB%A6%AC-%EA%B4%80%EB%A6%AC#Memory-Management%20Unit%20(MMU)-1)
https://velog.io/@kku64r/paging