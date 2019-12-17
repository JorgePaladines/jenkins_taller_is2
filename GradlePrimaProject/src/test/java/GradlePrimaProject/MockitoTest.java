package GradlePrimaProject;

import static org.mockito.Mockito.*;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.*;
import org.mockito.quality.Strictness;

import static org.mockito.AdditionalAnswers.returnsFirstArg;

final class FinalClass {
    public final String finalMethod() { return "something"; }
}


public class MockitoTest  {

	//4.1
    @Mock
    MyDatabase databaseMock;

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testQuery()  {
        ClassToTest t  = new ClassToTest(databaseMock);
        boolean check = t.query("* from t");
        assertTrue(check);
        verify(databaseMock).query("* from t");
    }
    
    
	
    //4.2.1
    @Test
    public void test1()  {
        //  create mock
    	CalcPrima calculoTest = mock(CalcPrima.class);

        // define return value for method getUniqueId()
        try {
			when(calculoTest.retornarPrima(0, 0)).thenReturn(850);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // use mock in test....
        try {
			assertEquals(850, calculoTest.retornarPrima(0, 0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    // demonstrates the return of multiple values
    @Test
    public void testMoreThanOneReturnValue()  {
        Iterator<String> i= mock(Iterator.class);
        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        String result= i.next()+" "+i.next();
        //assert
        assertEquals("Mockito rocks", result);
    }
    
    // this test demonstrates how to return values based on the input
    @Test
    public void testReturnValueDependentOnMethodParameter()  {
        Comparable<String> c= mock(Comparable.class);
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);
        //assert
        assertEquals(2, c.compareTo("Eclipse"));
    }
    
    // this test demonstrates how to return values independent of the input value
    @Test
    public void testReturnValueInDependentOnMethodParameter()  {
        Comparable<Integer> c= mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        //assert
        assertEquals(-1, c.compareTo(9));
    }

    // return a value based on the type of the provide parameter
    @Test
    public void testReturnValueInDependentOnMethodParameter2()  {
        Comparable<CalcPrima> c= mock(Comparable.class);
        when(c.compareTo(isA(CalcPrima.class))).thenReturn(0);
        //assert
        assertEquals(0, c.compareTo(new CalcPrima()));
    }
    
    //Excepción
    @Test
    public void testException() {
    	Properties properties = mock(Properties.class);

    	when(properties.get("Anddroid")).thenThrow(new IllegalArgumentException());

    	try {
    	    properties.get("Anddroid");
    	    fail("Anddroid is misspelled");
    	} catch (IllegalArgumentException ex) {
    	    // good!
    	}
    }
    
   
	//4.3
    @Test
    public void testLinkedListSpyCorrect() {
        // Lets mock a LinkedList
        List<String> list = new LinkedList<>();
        List<String> spy = spy(list);

        // You have to use doReturn() for stubbing
        doReturn("foo").when(spy).get(0);

        assertEquals("foo", spy.get(0));
    }
    
    
    @Test
    public void testRetornarPrima() throws Exception {
    	CalcPrima calculoTest = new CalcPrima();
    	CalcPrima spy = spy(calculoTest);
    	
		doReturn(850).when(spy).retornarPrima(0, 0);
		assertEquals(850, (int)spy.retornarPrima(0, 0));
    }
    
    //4.4
    @Test
	public void testVerify() throws Exception {
		CalcPrima calculoTest = mock(CalcPrima.class);
		when(calculoTest.retornarPrima(0, 0)).thenReturn(850);
		
		//Llamadas a los métodos
		calculoTest.retornarPrima(30, 28);
		calculoTest.retornarPrima(0, 0);
		calculoTest.retornarPrima(0, 0);
		
		//Verificaciones
		verify(calculoTest).retornarPrima(ArgumentMatchers.eq(30), ArgumentMatchers.eq(28));
		verify(calculoTest ,times(2)).retornarPrima(ArgumentMatchers.eq(0), ArgumentMatchers.eq(0));
		verify(calculoTest, never()).aplicaReduccion(0, 0);
		
		verifyNoMoreInteractions(calculoTest);

	}
	
	//4.7
	@Test
	public final void answerTest() throws Exception {
		CalcPrima calculoTest = mock(CalcPrima.class);
		when(calculoTest.retornarPrima(anyInt(), anyInt())).thenAnswer(returnsFirstArg());
		calculoTest.retornarPrima(30, 28);
	}
	
	
	/*
	// 4.8
	// No está cargando el archivo para las clases Final
	// A veces también sale un mensaje de que no se puede inicializar el plugin y no deja correr ningún Test
	@Test
	public final void mockFinalClassTest() {
	     FinalClass instance = new FinalClass();

	     FinalClass mock = mock(FinalClass.class);
	     when(mock.finalMethod()).thenReturn("that other thing");

	     assertNotEquals(mock.finalMethod(), instance.finalMethod());
	}
	*/
	
	/*
	//4.9
	//Pero las Excepciones correctas no están siendo retornadas
	@Rule public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
	@Test
	public void withStrictStubsTest() throws Exception {
	    CalcPrima calculo = mock(CalcPrima.class);

	    when(calculo.retornar_prima(0, 0)).thenReturn(42);
	    
	    // this fails now with an UnnecessaryStubbingException since it is never called in the test
	    when(calculo.rango_edad(1)).thenReturn(null);

	    // this will now throw a PotentialStubbingProblem Exception since we usually don't want to call methods on mocks without configured behavior
	    calculo.aplica_reduccion(1, 1);

	    assertEquals(42, (int)calculo.retornar_prima(0, 0));
	    
	    // verifyNoMoreInteractions now automatically verifies that all stubbed methods have been called as well
	    verifyNoMoreInteractions(calculo);
	}
	*/
    
}


