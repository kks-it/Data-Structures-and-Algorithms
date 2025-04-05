import java.util.ArrayList;
import java.util.List;

class Subsets{
    public static void main(String[] args){

    }

    public static List<StringBuilder> findAllSubsetsStringsIteratively(int[] nums){
        List<StringBuilder> subsets = new ArrayList<>();
        subsets.add(new StringBuilder());

        for(int num: nums){
            int size = subsets.size();
            for(int i = 0; i < size; i++){
                StringBuilder subset = new StringBuilder(subsets.get(i));
                subsets.add(subset.append(num));
            }
        }

        return subsets;
    }
    public static List<StringBuilder> findAllSubsetsStringsRecursively(int[] nums, int idx, StringBuilder sb){
        if(idx == nums.length){
            List<StringBuilder> base = new ArrayList<>();
            base.add(new StringBuilder(sb));
            return base;
        }

        List<StringBuilder> res = findAllSubsetsStringsRecursively(nums, idx + 1, sb.append(nums[idx] ));
        sb.deleteCharAt(sb.length() - 1);
        res.addAll(findAllSubsetsStringsRecursively(nums, idx + 1, sb));

        return res;
    }

    public static List<List<Integer>> findAllSubsetListsRecursively(int[] nums, int index, List<Integer> lsf){
        if(index == nums.length){
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>(lsf));
            return base;
        }

        List<List<Integer>> res = findAllSubsetListsRecursively(nums, index + 1, lsf);
        lsf.add(nums[index]);
        res.addAll(findAllSubsetListsRecursively(nums, index + 1, lsf));
        lsf.removeLast();

        return res;
    }

    public static List<List<Integer>> findAllSubsetsListsIteratively(int[] nums){

        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for(int i = 0; i < nums.length; i++){
            int size = subsets.size();

            for(int j = 0; j < size; j++){
                List<Integer> take = new ArrayList<>(subsets.get(j));
                take.add(nums[i]);
                subsets.add(take);
            }
        }

        System.out.println(subsets);
        return subsets;
    }
}