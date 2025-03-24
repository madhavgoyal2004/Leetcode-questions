// class Solution {
//     public int countDays(int days, int[][] meetings) {
//         Arrays.sort(meetings, (a,b)-> Integer.compare(a[0],b[0]));
        
//         for(int i=0; i<meetings.length-1; i++){
//             if(meetings[i][1] >= meetings[i+1][0]){
//                 meetings[i+1][0] = meetings[i][0];
//                 meetings[i][0] = 0;
//                 meetings[i][1] = 0;
//             }
//         }
        
//         for(int i=0; i<meetings.length ; i++){
//             if(meetings[i][0] != meetings[i][1] || meetings[i][0] == 0){
//                 int remain = meetings[i][1] - meetings[i][0] + 1;
//                 days = days - remain;
//             }
//         }
//         return days;
//     }
// }


class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int count = 0;
        int end = 0;
        for (int[] meeting : meetings) {
            if (meeting[0] > end) {
                count += meeting[0] - end - 1;
            }
            end = Math.max(end, meeting[1]);
        }
        count += days - end;
        return count;
    }
}