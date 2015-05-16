package BrightDeath;

import Items.Item;
import java.util.List;

public class Dialogue {
    
    private final String speach;
    private final List<Response> responses;
    private final int quest;
    private final Item reward;
        
    public Dialogue(String text, List<Response> answers, int task, Item gift, boolean stop)
    {
        speach = text;
        responses = answers;
        quest = task;
        reward = gift;
    }
    
    public int getNumberResponses()
    {
        return responses.size();
    }
    
    public String getSpeach()
    {
        return speach;
    }
    
    public Response getResponse(int a)
    {
        return responses.get(a);
    }
    
    public int getQuest()
    {
        return quest;
    }
    
    public Item getReward()
    {
        return reward;
    }
}