class Solution {
    static Map<Integer,Integer> map;
    public int climbStairs(int n) {
        map = new HashMap<>();
        return dfs(0,n);
    }

    public static int dfs(int cur, int goal){
        if(map.containsKey(cur)){
            return map.get(cur);
        }
        
        if(cur >  goal){return 0;}
        if(cur == goal){return 1;}

        int res =  dfs(cur+1, goal)+dfs(cur+2, goal);
        map.put(cur, res);        
        return res;
    }
}
