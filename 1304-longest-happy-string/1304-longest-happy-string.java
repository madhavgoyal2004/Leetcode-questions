class Pair{
    char ch;
    int c;
    Pair(char ch , int c){
        this.ch = ch;
        this.c = c;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> q = new PriorityQueue<>((o1, o2) -> o2.c - o1.c);

        if(a> 0) q.add(new Pair('a', a));
        if(b>0) q.add(new Pair('b', b));
        if(c > 0) q.add(new Pair('c', c));

        StringBuilder s = new StringBuilder();
        while (s.length() <= (a+b+c)){
            if(q.isEmpty()) break;
            Pair curr = q.poll();
            if(curr.c == 0) break;
            if(s.length() < 2){
                s.append(curr.ch);
                q.offer(new Pair(curr.ch, curr.c - 1));
            }
            else if(s.charAt(s.length()-1) == curr.ch && s.charAt(s.length() - 2) == curr.ch){
                if(q.isEmpty()) break;
                Pair s_curr = q.poll();
                if(s_curr.c == 0) break;

                s.append(s_curr.ch);
                q.offer(new Pair(s_curr.ch, s_curr.c - 1));
                q.offer(curr);
            }
            else{
                s.append(curr.ch);
                q.offer(new Pair(curr.ch, curr.c -1));
            }
        }

        return s.toString();

    }
}