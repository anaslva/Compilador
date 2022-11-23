package gals;
public class SyntaticError extends AnalysisError
{
    public SyntaticError(String msg, int position, Token token)
    {
        super(msg, position, token);
    }

    public SyntaticError(String msg)
    {
        super(msg);
    }
}
