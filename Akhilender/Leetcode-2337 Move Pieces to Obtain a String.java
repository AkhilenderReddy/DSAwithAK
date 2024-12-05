class Solution {
    public boolean canChange(String start, String target) {
        int rs=0;
        for(int i=0;i<start.length();i++){
            if(start.charAt(i)=='R'){
                rs++;
            }if(target.charAt(i)=='R'){
                if(rs>0){
                    rs--;
                }else{
                    return false;
                }
            }
        }
        int ls=0;
        for(int i=start.length()-1;i>=0;i--){
            if(start.charAt(i)=='L'){
                ls++;
            }if(target.charAt(i)=='L'){
                if(ls>0){
                    ls--;
                }else{
                    return false;
                }
            }
        }
        if(start.replace("_","").equals(target.replace("_",""))){
            return true;
        }else{
            return false;
        }
        
    }
}