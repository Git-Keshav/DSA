class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for (int j = 1; j <= n; j++) {
            if (j % 3 == 0 && j % 5 == 0) {
                answer.add("FizzBuzz");
            }else if(j % 3 == 0){
                answer.add("Fizz");
            }else if(j % 5 == 0){
                answer.add("Buzz");
            }else{
                answer.add(String.valueOf(j));
            }
        }
        return answer;
    }
}