import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
	


class TestDemoTest {
	private TestDemo testDemo;

	@BeforeEach
	void setUp() {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}else{
			assertThatThrownBy(() -> 
		    testDemo.addPositive(a, b))
		        .isInstanceOf(IllegalArgumentException.class);
			}
			
		}
	public static Stream<Arguments> argumentsForAddPositive(){
		
	
			
		return Stream.of(
				Arguments.arguments(2, 4, 6, false),
	            Arguments.arguments(10, 5, 15, false),
	            Arguments.arguments(-3, 7, 4, true),
	            Arguments.arguments(0, 10, 10, true),
	            Arguments.arguments(2, -5, -3, true),
	            Arguments.arguments(100, -100, 0, true),
	            Arguments.arguments(1, 1, 2, false),
	            Arguments.arguments(-1, -1, -2, true),
	            Arguments.arguments(5, 0, 5, true),
	            Arguments.arguments(0, 0, 0, true),
	            Arguments.arguments(1, 2, 3, false),
	            Arguments.arguments(-1, -2, -3, true)
				);
	}
	@Test
	  void assertThatNumberSquaredIsCorrect() {
        TestDemo mockDemo = spy(testDemo);
        doReturn(5).when(mockDemo).getRandomInt();

        int fiveSquared = mockDemo.randomNumberSquared();
        int expectedResult = 5 * 5;

        assertEquals(expectedResult, fiveSquared);
    }

}
