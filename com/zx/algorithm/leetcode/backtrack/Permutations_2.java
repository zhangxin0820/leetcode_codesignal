package com.zx.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangxin on 2021/12/23.
 * Time : 21:27
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class Permutations_2 {

    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Permutations_2 permutations = new Permutations_2();
        System.out.println(permutations.permute(new int[]{1, 2, 1}));
    }

    private List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, tmp, used);
        return res;
    }

    private void dfs(int[] nums, List<Integer> tmp, boolean[] used) {
        int n = nums.length;
        if (tmp.size() == n) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            // 同一层的去重 例如{1,1,2} 使用第二个1的时候 nums[i] == nums[i-1]是成立的
            // 此时由于回溯的原因 used[i-1] == false也成立 说明前一个1已经被使用过了
            // 所以不能再使用当前的1了 需要continue
            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == false) continue;
            tmp.add(nums[i]);
            used[i] = true;
            dfs(nums, tmp, used);
            used[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
