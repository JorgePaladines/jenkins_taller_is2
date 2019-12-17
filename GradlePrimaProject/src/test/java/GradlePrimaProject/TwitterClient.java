package GradlePrimaProject;

import static org.mockito.Mockito.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TwitterClient {

    public void sendTweet(ITweet tweet) {
        String message = tweet.getMessage();

        // send the message to Twitter
    }
    
    @Test
    public void testSendingTweet() {
        TwitterClient twitterClient = new TwitterClient();

        ITweet iTweet = mock(ITweet.class);

        when(iTweet.getMessage()).thenReturn("Using mockito is great");

        twitterClient.sendTweet(iTweet);
        
        verify(iTweet, atLeastOnce()).getMessage();
    }
}