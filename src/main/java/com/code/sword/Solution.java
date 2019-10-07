/*
 * Solution.java
 * Copyright 2019 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.code.sword;


import com.code.leetcode.node.ListNode;
import com.sun.istack.internal.NotNull;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author damai
 *
 */

public class Solution {
    public static void main(String[] args) {
        new Solution().FindPathRun();
    }
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public int minNumberInRotateArray(int[] array) {
        if (array.length < 1) {
            return 0;
        }

        int nextValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }

        return 0;

    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode root = pNode;
        List <TreeLinkNode> list = new ArrayList <TreeLinkNode>();
        while (root.next != null) {
            root = root.next;
        }

        meduimTree(root, list);
        int orderValue = 0;
        for (int i = 0; i < list.size(); i++) {
            if (pNode == list.get(i)) {
                return i == list.size() - 1 ? null : list.get(i + 1);
            }
        }
        return null;

    }

    void meduimTree(TreeLinkNode treeLinkNode, List <TreeLinkNode> list) {
        if (null == treeLinkNode) {
            return;
        }
        meduimTree(treeLinkNode.left, list);
        list.add(treeLinkNode);
        meduimTree(treeLinkNode.right, list);
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (null == pRoot) {
            return true;
        }

        return isSymmetricalHelp(pRoot.left, pRoot.right);
    }

    boolean isSymmetricalHelp(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            } else {
                return isSymmetricalHelp(left.left, right.right) && isSymmetricalHelp(left.right,
                        right.left);
            }
        } else {
            return false;
        }
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        List <TreeNode> list = new ArrayList <TreeNode>();
        KthNodeHelper(pRoot, list);
        if (k > list.size()) {
            return null;
        }
        return k > list.size() ? null : list.get(k - 1);

    }

    void KthNodeHelper(TreeNode pRoot, List <TreeNode> list) {
        if (pRoot != null) {
            KthNodeHelper(pRoot.left, list);
            list.add(pRoot);
            KthNodeHelper(pRoot.right, list);
        }
    }

    List <ArrayList <Integer>> printFromTopToBottomList = new ArrayList <>();

    public ArrayList <Integer> PrintFromTopToBottom(TreeNode root) {
        PrintFromTopToBottomHelper(root, 1);
        List <Integer> resultList =
                printFromTopToBottomList.stream().flatMap(list -> list.stream()).collect(
                        Collectors.toList());
        return (ArrayList <Integer>) resultList;
    }

    public void PrintFromTopToBottomHelper(TreeNode treeNode, int deep) {
        if (treeNode == null) {
            return;
        }
        if (printFromTopToBottomList.size() < deep) {
            printFromTopToBottomList.add(new ArrayList <>());
        }
        printFromTopToBottomList.get(deep - 1).add(treeNode.val);
        PrintFromTopToBottomHelper(treeNode.left, deep + 1);
        PrintFromTopToBottomHelper(treeNode.right, deep + 1);

    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        if (Math.abs(right - left) > 1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;

    }

    public int GetNumberOfK(int[] array, int k) {
        return (int) Arrays.stream(array).filter(num -> num == k).count();
    }

    public int FirstNotRepeatingChar(String str) {
        HashMap <Character, Integer> characterIntegerHashMap = new HashMap <>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            int count = characterIntegerHashMap.getOrDefault(c, 0);
            count++;
            characterIntegerHashMap.put(c, count);
        }
        List <Map.Entry <Character, Integer>> list = characterIntegerHashMap.entrySet().stream().
                filter(characterIntegerEntry -> characterIntegerEntry.getValue() == 1).collect(
                Collectors.toList());
        if (list.isEmpty()) {
            return -1;
        } else {
            return list.stream().map(entry -> str.indexOf(entry.getKey())).sorted().findFirst()
                    .get();
        }
    }

    List <Integer> mList = new ArrayList <>();

    public ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode Head = new ListNode(0);
        Head.next = pHead;
        ListNode pre = Head;
        ListNode last = Head.next;
        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                // 找到最后的一个相同节点
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            } else {
                pre = pre.next;
                last = last.next;
            }
        }
        return Head.next;

    }

    ArrayList<ArrayList<Integer>> pList = new ArrayList <>();
    //之字形打印二叉树
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if (pRoot == null){
            return pList;
        }
        PrintHelper(pRoot, 1);

        for (int i=0; i<pList.size(); i++){
            //单数需要反转
            if (i%2 != 0){
                Collections.reverse(pList.get(i));
            }
        }
        return pList;
    }
    public void PrintHelper(TreeNode root, int depth){
        if (null == root){
            return;
        }

        if (pList.size() < depth ){
            pList.add(new ArrayList <>());
        }
        pList.get(depth -1).add(root.val);

        PrintHelper(root.left, depth + 1);
        PrintHelper(root.right, depth + 1);


    }



    public double Power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    public void reOrderArray(int [] array) {
        if (null == array || array.length <= 1){
            return;
        }

        List<Integer> list1 = new ArrayList <>();
        List<Integer> list2 = new ArrayList <>();

        for (int i:array){
            if (i%2 ==0){
                list2.add(i);
            }else {
                list1.add(i);
            }
        }
        list1.addAll(list2);
        int i=0;
        list1.stream().forEach(s -> {
            array[list1.indexOf(s)] = s;
        });


    }
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null){
            return head;
        }
        List<ListNode> listNodes = new ArrayList <>();
        while (head != null){
            listNodes.add(head);
            head = head.next;
        }

        return listNodes.size() > k ? listNodes.get(listNodes.size() - k-1):null;
    }

    List<Integer> sortList = new ArrayList <>();
    public void Insert(Integer num) {
        sortList.add(num);
    }

    public Double GetMedian() {
        List<Integer> list = sortList.stream().sorted().collect(Collectors.toList());
        if (list.size() % 2 != 0){
            return (double) list.get(list.size() / 2);
        }else {
            int index1  = list.size() / 2;
            return ((double)list.get(index1-1) + (double)list.get(index1)) / 2;
        }
    }

    Stack<Integer> mIntegers = new Stack <>();
    int minValue = Integer.MAX_VALUE;
    public void push(int node) {
        mIntegers.push(node);
    }

    public void pop() {
        mIntegers.pop();
    }

    public int top() {
      return  mIntegers.peek();
    }

    public int min() {
        mIntegers.stream().forEach(num ->{
            minValue = Math.min(num, minValue);
        });
        return minValue;
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        List<Integer> list1 = new ArrayList <>();
        List<Integer> list2 = new ArrayList <>();
        List<Integer> list3 = new ArrayList <>();
        List<Integer> list4 = new ArrayList <>();
        if (root1 == null || root2 == null){
            return false;
        }
        inorder(root1, list1);
        inorder(root2, list2);
        if (!list1.toString().contains(list2.toString())){
            return false;
        }
        perorder(root1, list3);
        perorder(root2, list4);
        return list3.toString().contains(list3.toString());

    }


   public void inorder(TreeNode root, List<Integer> list){
        if (null == root){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);

    }

    public void perorder(TreeNode root, List<Integer> list){
        if (null == root){
            return;
        }

        list.add(root.val);
        inorder(root.left, list);
        inorder(root.right, list);

    }

    /**
     * 镜像二叉树
     */
    public void Mirror(TreeNode root) {
        if (null == root){
            return;
        }

    }
    public void MirrorTree(TreeNode left, TreeNode right) {
        if (left == null){

        }
        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;
        MirrorTree(left.left, right.right);
        MirrorTree(left.right, right.left);

    }
    public void PrintMinNumberRun(){
        int[] numbers = {3,5,1,4,2};
        System.out.println(PrintMinNumber(numbers));
    }

    public String PrintMinNumber(int [] numbers) {
        List<String> list = new ArrayList<>();
        for (int num:numbers){
            list.add(String.valueOf(num));
        }
        PrintMinNumberPer(list, new ArrayList<>());
        Collections.sort(resultList);
        String result = resultList.size() > 0 ? resultList.get(0):null;
        return result;
    }
    ArrayList<String> resultList = new ArrayList<>();
    public void PrintMinNumberPer(List<String> integers, List<String> reult) {
        if (integers.size() == reult.size()){
            System.out.println(reult.toString());
            String str = "";
            for (String s:reult){
                str += s;
            }
            resultList.add(str);
        }else {
            for (int i=0;i<integers.size();i++){
                if (!reult.contains(integers.get(i))){
                    List<String> tmp = new ArrayList<>();
                    tmp.addAll(reult);
                    tmp.add(integers.get(i));
                    PrintMinNumberPer(integers, tmp);
                }
            }
        }
    }
    /**
     * 全排列算法
     * 获取所有的组合
     */
    public void permutation(String s, String result, int length){
        //result的长度与预期组合长度相同时，打印出结果
        if (length == result.length()){
            System.out.println(result);
        }else {
            for (int i=0;i<s.length();i++){
                //检查result里面是否含有s.charAt（i） 这个对象
                if (result.indexOf(s.charAt(i))<0){
                    permutation(s, result+s.charAt(i), length);
                }
            }
        }
    }

    public void permutationRun(){
        String s = "abcd";
        permutation(s, "", s.length());
    }

    ArrayList<String> permutationResult = new ArrayList<>();
    public void PermutationRun(){
        Permutation("a");
        System.out.println(permutationResult.toString());
    }
    public ArrayList<String> Permutation(String str) {
        if (null == str || str.isEmpty()){
            return permutationResult;
        }

        PermutationRecursive(str, "");
        return permutationResult;
    }

    public void PermutationRecursive(String str, String result) {
        if (str.length() == result.length()){
            System.out.println(result);
            String addStr = "";
            for (int i=0; i<result.length(); i++){
                System.out.println(result.charAt(i));
                int index = Integer.valueOf(String.valueOf(result.charAt(i)));
                addStr += str.charAt(index);
            }
            if (!permutationResult.contains(addStr)){
                permutationResult.add(addStr);

            }
        }else {
            for (int i=0;i<str.length();i++){
                if (result.indexOf(String.valueOf(i)) < 0){
                    //result 存放索引，因为str的数字可能有重复的
                    PermutationRecursive(str, result + i);
                }
            }
        }
    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (null == numbers || numbers.length <= 1){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<length; i++){
            int count = map.getOrDefault(numbers[i], 0);
            count ++;
            if (count == 2){
                duplication[0] = 2;
                return true;
            }
        }
        return false;
    }

    ArrayList<ArrayList<Integer>> FindPathArrayList = new ArrayList<>();
    public void FindPathRun(){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        FindPath(treeNode1, 3);
        for (ArrayList<Integer> arrayList:FindPathArrayList){
            System.out.println(arrayList.toString());
        }
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (null == root){
            return FindPathArrayList;
        }
        FindPathDec(root, new ArrayList<Integer>(), 0, target);
        return FindPathArrayList;
    }
    public void FindPathDec(TreeNode treeNode, ArrayList<Integer> path, int result, int target){
        if (null == treeNode){
            return;
        }
        result += treeNode.val;
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.addAll(path);
        tmp.add(treeNode.val);
        if (result == target && treeNode.left == null && treeNode.right == null){
            System.out.println(tmp.toString());
            FindPathArrayList.add(tmp);
        }else if (result < target){
            FindPathDec(treeNode.left, tmp, result , target);
            FindPathDec(treeNode.right, tmp, result , target);
        }

    }




    }

