class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for(Integer index=1; index<=n; index++)
        {
            if(index%3==0 && index%5==0)
                answer.add("FizzBuzz");
            else if(index%3==0) 
                answer.add("Fizz");
            else if(index%5==0) 
                answer.add("Buzz");
            else
                answer.add(index.toString());
        }
        return answer;
    }
}