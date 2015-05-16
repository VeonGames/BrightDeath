package BrightDeath;

import Items.Item;

public class Response {
    
    private final String answer;
    private final int dialogue;
    private final int quest;
    private final Item reward;
    private final boolean end;
    
    public Response(String text, int speach, int task, Item gift, boolean stop)
    {
        answer = text;
        dialogue = speach;
        quest = task;
        reward = gift;
        end = stop;
    }
    
    public String getAnswer()
    {
        return answer;
    }
    
    public int getSpeech()
    {
        return dialogue;
    }
    
    public int getQuest()
    {
        return quest;
    }
    
    public Item getReward()
    {
        return reward;
    }
    
    public boolean isEnd()
    {
        return end;
    }
}
