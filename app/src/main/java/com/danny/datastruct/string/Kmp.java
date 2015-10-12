package com.danny.datastruct.string;

public class Kmp {
	int bruteForceMatch(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		
		int i = 0, j = 0;
		//终点:当j走到尽头时,说明匹配成功.i走到尽头时, 说明匹配失败 
		while (i<sLen && j<pLen) {
			if (s.charAt(i) == p.charAt(j)) {
				++i;
				++j;
			} else {
				//匹配失败, i倒退回i的后一个
				i = i - j + 1;
				j = 0;
			}
		}
		//匹配成功, 返回i的起始值
		if (j == pLen)
			return i - j;
		else return -1;
	}
	private int[] next;
	
	private void getNext(String p) {
		next = new int[p.length()];
		next[0] = -1;
		int k = -1;
		int j = 0;
		while (j < p.length() - 1) {
			if (k == -1 || p.charAt(j) == p.charAt(k)) {
				++j;
				++k;
				next[j] = k;
			} else {
				k = next[k];
			}
		}
	}
	
	public int kmp(String s, String p) {
		getNext(p);
		int sLen = s.length();
		int pLen = p.length();
		int i=0, j=0;
		int times = 0;
		while (i<sLen && j<pLen) {
			++times;
			if (j == -1 || s.charAt(i) == p.charAt(j)) {
				++i;
				++j;
			} else {
				j = next[j];
			}
		}
		System.out.println("round times:" + times);
		if (j == pLen)
			return i - j;
		return -1;
	}
	int bruteForceMatch2(String s, String p) {
		int max = s.length() - p.length();
		for (int i=0; i<max; i++) {
			int j=0;
			for (; j<p.length(); j++) {
				if (s.charAt(i+j) != p.charAt(j))
					break;
			}
			if (j == p.length())
				return i;
		}
		return -1;
	}
	
	public int bruteForceMatch3(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		int i, j;
		for (i=0, j=0; i<sLen && j<pLen; i++) {
			if (s.charAt(i) == p.charAt(j))
				j++;
			else {
				i -= j;
				j = 0;
			}
		}
		if (j == pLen)
			return i - j;
		return -1;
	}
	

}
