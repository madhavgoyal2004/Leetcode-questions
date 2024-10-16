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

        q.add(new Pair('a', a));
        q.add(new Pair('b', b));
        q.add(new Pair('c', c));

        String s = "";
        while (s.length() <= (a+b+c)){
            Pair curr = q.poll();
            if(curr.c == 0) break;
            if(s.length() < 2){
                s += curr.ch;
                q.offer(new Pair(curr.ch, curr.c - 1));
            }
            else if(s.charAt(s.length()-1) == curr.ch && s.charAt(s.length() - 2) == curr.ch){
                Pair s_curr = q.poll();
                if(s_curr.c == 0) break;

                s += s_curr.ch;
                q.offer(new Pair(s_curr.ch, s_curr.c - 1));
                q.offer(curr);
            }
            else{
                s += curr.ch;
                q.offer(new Pair(curr.ch, curr.c -1));
            }
        }

        return s;

    }
}