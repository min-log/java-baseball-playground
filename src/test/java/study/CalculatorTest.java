package study;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

@Logger
public class CalculatorTest {

    /**
 * - 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
 * - 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
 *  (즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.)
 * - 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 *
 */
    int Calculator(String[] values) {

        List<String> list = Arrays.asList("+", "-", "*", "/");
        int total = 0;


        for (int i= 0; i < values.length; i++ ) {

            // item 이  calc 이 아니면 prev, calc 에 포함되면 스위치에 들어가서 prev와 next를 계산
            //calc 에 포함된 값인지 확인 true, false

            String item = values[i];

            int next = 0;

            if(list.contains(item)){

                next = Integer.parseInt(values[i+1]);

                switch (item){
                    case "+":
                        System.out.println(total +" +=" + next);
                        total += next;

                        break;
                    case "-":
                        System.out.println(total +" -=" + next);
                        total -= next;
                        break;
                    case "*":
                        System.out.println(total +" *=" + next);
                        total *= next;
                        break;
                    case "/":
                        System.out.println(total +" *=" + next);
                        total /= next;
                        break;
                }

                i++; // 연산자로 이동

            }else if(values[0].equals(item)) {

                total = Integer.parseInt(item);

            }
        };


        return total;
    }


    @Test
    void test() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("계산식을 입력하세요 (예: 2 + 3 * 4 / 2): ");
//        String value = scanner.nextLine();
        String value = "- 2 + 3 * 4 / 2";

        String[] values = value.split(" ");


        int result = Calculator(values);

        // 테스트 결과 total 출력
        System.out.println("결과: " + result);
        assertThat(result).isEqualTo(2);



    }





}
