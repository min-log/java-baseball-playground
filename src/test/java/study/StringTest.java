package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }


    @Test
    void splitToArray() {
        String[] actual = "1,2".split(",");
        Assertions.assertThat(actual).contains("1", "2");
    }

    @Test
    void splitToOne() {
        String[] actual = "1".split(",");
        Assertions.assertThat(actual).containsExactly("1");
    }



    @Test
    void splitToNumber() {
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void charAtTest(){
        try {
            char c = "abc".charAt(4);
            Assertions.assertThat(c).isEqualTo('c');

        }catch (Exception e){
            e.printStackTrace();
        }
    }



    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }









}
