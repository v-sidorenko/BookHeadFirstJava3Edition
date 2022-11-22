package page540;

public class QuizCard
{
    private final String question;
    private final String answer;

    public QuizCard(String question, String answer)
    {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion()
    {
        return this.question;
    }

    public String getAnswer()
    {
        return this.answer;
    }
}
