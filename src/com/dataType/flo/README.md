

📌 실수 자료형의 이해
-
* 실수 자료형은 같은 계산 식이라도 컴파일러 최적화나, 순서, 중간에 로그 출력 여부 등등에 따라서 달라질 수 있음
* 실수의 이진법 표기하기
    - 십진소수 : 12.34 => 10*1 + 1*2 + (1/10)*3 + (1/100)*4
    - 이진소수 : 1011.101 => 8*1 + 4*0 + 2*1 + 1*1 + (1/2)*1 + (1/4)*0 + (1/8)*1 => 십진 소수로 11.625 이다.


<br/>

📌 부동 소수점 표기
-
* 특정 비트는 부호로, 특정 비트는 정수부 + 소수부를 쓰는 방식으로 표기하는 것을 고정소수점 표기법이라고 함
    - 이는 이해하기는 쉬우나, 큰 수를 표현하기에는 무리가 있음.
    - 또한 정수부 소수부 크기를 일정으로 정해버리면 들어오는 수에 따라 표현할 수 있는 수의 크기가 한정적 (소수부가 크면 정확도는 높아지지만, 표현 가능 숫자의 크기는 줄어듬)
    
* 위 문제점으로 IEEE754 표준을 따르기로함. 
    1. 소수점 위 숫자가 1개가 될 때까지 옮기기
    2. 소수점을 몇칸이나 옮겼는지 기록하기
    3. 나머지 숫자 기록하기
    * 이를 소수점이 움직이는 표기법이라고 해서 부동 소수점 표기법이라고 함
    
* IEEE754 예시
    1. 11.625 는 이진소수로 1011.101
    2. 앞으로 세칸 옮기면 1.011101 이 되고 옮킨 칸의 수는 3칸. 1011.101 * 2^0 = 1.01101 * 2^3 => 여기서 기록하는 숫자는 .01101 과 3 그리고 부호 여부
    3. 이 때 소수점 위에 있을 수 있는 수는 0 안되고 무조건 1로 함으로써 1은 비트에서 제외한다 => 1비트 절약. 
    4. 정수부를 무조건 1로 만들고 이동한 숫자 자리수 만큼 지수로 표현해서 훨씬 더 큰 값을 담을 수 있게 되었음
    5. 이렇게 표현하는 것을 정규화라고 한다.
    6. 이 때 가수부가 표현할 수 있는 비트 수 이하 숫자는 반올림 된 후 버려지는데, 이 것 때문에 계산할 때 오차가 발생함 => 실수의 경우 늘 근사치로 표현됨
    7. 따라서 두 실수가 같은지 확인을 하려면, 값이 같은지 확인하는 것이 아닌 오차 한도가 충분한 크기 내로 들어오는지를 확인해야함 
    
* 부동소수점에서 실수는 다음과 같은 3가지의 정보를 저장함 
    1. 부호 비트(sign bit) : 양수인지 음수인지
    2. 지수 (exponent) : 소수점을 몇칸 옮겼는지
    3. 가수 (mantissa) : 소수점을 옮기고 난 후 생긴 실수의 최상위 부터 n개의 비트 (정확도가 크다는 것은 n이 더 늘어난다는 것을 의미)

* 오차한도 정하는 방법 : 숫자 a와 b가 같은지 비교할 때, 오차한도를 정하는 공식은 
    - | a - b | / 둘중 더 큰 수이다. 
    - 예를 들어서 1/10*3 과 3/10 이 같은지 허용하는 범위오차를 구하려면
    - Math.abs(((double)1/10)*(double)3 - ((double)3/10)) / Math.max(((double)1/10)*(double)3, ((double)3/10)); 이렇게 하면 되고 
    - 값은 1.850371707708594E-16이 나온다.
    

여기서 1e-10 이란 10의 -10 승에 해당하는 숫자이다.



