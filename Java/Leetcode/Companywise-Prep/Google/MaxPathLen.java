
// LEETCODE: 388
class Solution {
    public int lengthLongestPath(String input) {
        String[] levels = input.split("\\n");
        HashMap<Integer/*Level*/, Integer/*Character Count*/> map = new HashMap<>();
        int max = 0;
        map.put(-1,0);
        for(int i=0; i<levels.length; i++) {
            String[] levelCnt =levels[i].split("\\t");
            int level_num = levelCnt.length - 1;
            //System.out.println("level num:"+level_num);
            int char_count = levelCnt[levelCnt.length-1].length();
           // System.out.println("level text:"+levelCnt[levelCnt.length-1]);
            if(levelCnt[levelCnt.length-1].contains(".")) {
                //System.out.println(" Last level text ext:"+map.get(level_num-1));
                max = Math.max(max,  map.get(level_num-1)+char_count);
            } else {
               // System.out.println(" Last level text:"+map.get(level_num-1));
                map.put(level_num, map.get(level_num-1) + char_count + 1);
            }
            
        }
        return max;
    }
    
}