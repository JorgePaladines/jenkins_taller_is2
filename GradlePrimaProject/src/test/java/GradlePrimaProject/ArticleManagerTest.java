package GradlePrimaProject;

import static org.mockito.Mockito.*;

import java.util.*;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ArticleManagerTest  {

       @Mock ArticleCalculator calculator;
       @Mock ArticleDatabase database;
       @Mock User user;

       @Spy private UserProvider userProvider = new ConsumerUserProvider();

       @InjectMocks private ArticleManager manager; 

       @Test public void shouldDoSomething() {
           // calls addListener with an instance of ArticleListener
           manager.initialize();

           // validate that addListener was called
           verify(database).addListener(any(ArticleListener.class));
       }
}